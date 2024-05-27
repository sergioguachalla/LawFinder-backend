package com.lawfinder.backend.bl;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lawfinder.backend.Entity.PersonEntity;
import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.dao.PersonRepository;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dao.UserRoleRepository;
import com.lawfinder.backend.dto.LoginDto;
import com.lawfinder.backend.dto.TokenDto;
import com.lawfinder.backend.services.EmailService;
import com.lawfinder.backend.services.PasswordService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthBl {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private final PersonRepository personRepository;
    @Autowired private LogBl logBl;

    @Autowired
    private final EmailService emailService;

    private Map<String, Integer> failedLoginAttempts = new HashMap<>();

    private Logger logger = org.slf4j.LoggerFactory.getLogger(AuthBl.class);


    public AuthBl(UserRepository userRepository, UserRoleRepository userRoleRepository, PersonRepository personRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.personRepository = personRepository;
        this.emailService = emailService;
    }
    public static final String KEY = "lawFinder_2023";



    public TokenDto login(LoginDto login, String ipAddress) {

        UserEntity userEntity = userRepository.findAllByUsername(login.getUsername());

        if(userEntity == null) {
            logBl.saveSecurityLog("desconocido", "Intento de inicio de sesion fallido de un usuario desconocido", ipAddress, 4L);
            return null;
        }
        if (userEntity.getIsblocked()) {
            return null;
        }
        if(!userEntity.getStatus()){
            return null;
        }

        List<String> roles = getRoles(userEntity.getId());
//        for (String role : roles) {
//            System.out.println(role);
//        }

        if (login.getUsername().equals(userEntity.getUsername()) &&
               PasswordService.checkPassword(login.getPassword(), userEntity.getSecret())
        ) {
            //limpiar los intentos
            failedLoginAttempts.put(login.getUsername(), 0);

            TokenDto tokenDto = new TokenDto();
            tokenDto.setAuthToken(generateToken(userEntity.getId(), login.getUsername(), "AUTH", 30, roles));
            tokenDto.setRefreshToken(generateToken(userEntity.getId(), login.getUsername() , "REFRESH", 60,roles));
            logBl.saveSecurityLog(login.getUsername(), "Inicio de sesion exitoso", ipAddress, 4L);
            return tokenDto;
        }

        else if (login.getUsername().equals(userEntity.getUsername())) {
            if (failedLoginAttempts.containsKey(login.getUsername())) {
                logBl.saveSecurityLog(login.getUsername(), "Intento de inicio de sesion fallido", ipAddress, 4L);
                failedLoginAttempts.put(login.getUsername(), failedLoginAttempts.get(login.getUsername()) + 1);
            } else {
                failedLoginAttempts.put(login.getUsername(), 1);
            }
            if (failedLoginAttempts.get(login.getUsername()) >= 3) {
                userEntity.setIsblocked(true);
                userRepository.save(userEntity);
                logBl.saveSecurityLog(login.getUsername(), "Usuario bloqueado por exceso de intentos", ipAddress, 4L);
            }
            return null;
        }
        else {
            return null;
        }
    }

    public boolean isAccountBlocked(String username) {
        UserEntity userEntity = userRepository.findAllByUsername(username);
        if (userEntity == null) {
            return false;
        }
        return userEntity.getIsblocked();
    }


    private String  generateToken(Long userId, String name, String type, int minutes, List<String> roles) {
        roles = getRoles(userId);
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);

            return JWT.create()
                    .withIssuer("lawfinder.com")
                    .withClaim("userId", userId)
                    .withClaim("type", type)
                    .withClaim("name", name)
                    .withClaim("roles", roles)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000L * 60 * minutes))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            System.out.println("Error al generar el token " + userId + " " + name + " " + type + " " + minutes);
            throw new RuntimeException("Error al generar el token", exception);
        }
    }

    public boolean validateToken(String token) {
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify a specific claim validations
                    .withIssuer("lawfinder.com")
                    // reusable verifier instance
                    .build();
            assert token != null;
            decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return false;
        }
    }

    public List<String> getRoles(Long id){
        //System.out.println(userRepository.getRolesByUserId(id));
        return userRoleRepository.findPrivilegesByUserId(id);
    }

    //unlock user
    public Boolean unlockUser(Long id, String username, String ipAddress) {
        UserEntity userEntity = userRepository.findByUserId(id);
        PersonEntity personEntity = personRepository.findByPersonId(userEntity.getPersonId().getPersonId());
        if (userEntity != null) {
            userEntity.setIsblocked(!userEntity.getIsblocked());
            userRepository.save(userEntity);
            emailService.sendEmailMime(personEntity.getEmail(), "Cuenta Verificada",
            "Su cuenta ha sido desbloqueada, ya puede iniciar sesion.\n\n" +
                    "Su nombre de usuario es: " + userEntity.getUsername() + "\n\n" +
                    "Gracias por usar LawFinder");

            if(userEntity.getIsblocked()) {
                logBl.saveLog(username, "Usuario bloqueado con id "+ userEntity.getId() , 2L,ipAddress,2L);
            } else {
                logBl.saveLog(username, "Usuario desbloqueado con id "+ userEntity.getId() , 2L,ipAddress,2L);
            }
            return true;
        } else {
            return false;
        }
    }


    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("X-Real-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
            ipAddress = "127.0.0.1";  // For localhost access testing
        } else if (ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();  // Handle multiple IPs (e.g., "X-Forwarded-For: client, proxy1, proxy2")
        }
        return ipAddress;
    }

}

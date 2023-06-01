package com.lawfinder.backend.bl;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dto.LoginDto;
import com.lawfinder.backend.dto.TokenDto;
import com.lawfinder.backend.dto.UserDto;
import com.lawfinder.backend.services.PasswordService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthBl {

    private final UserRepository userRepository;

    public AuthBl() {
        this.userRepository = null;

    }

    public AuthBl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public static final String KEY = "lawFinder_2023";



    public TokenDto login(LoginDto login) {
        List<UserEntity> userEntityAll = userRepository.findAllByUsername(login.getUsername());
        UserEntity userEntityLogin = new UserEntity();
        for (UserEntity userEntity : userEntityAll) {
            if(userEntity.getUsername().equals(login.getUsername())){
                    //userEntity.getSecret().equals(login.getPassword())){
                System.out.println("Login: " + userEntity.getUsername() + " " + userEntity.getSecret());
                 userEntityLogin = userEntity;
            }
        }
        System.out.println("Logi2n: " + userEntityLogin.getUsername() + " " + userEntityLogin.getSecret());

        if (login.getUsername().equals(userEntityLogin.getUsername()) &&
               PasswordService.checkPassword(login.getPassword(), userEntityLogin.getSecret())) {
            TokenDto tokenDto = new TokenDto();
            tokenDto.setAuthToken(generateToken(userEntityLogin.getId(), login.getUsername(), "AUTH", 30));
            tokenDto.setRefreshToken(generateToken(userEntityLogin.getId(), login.getUsername() , "REFRESH", 60));
            return tokenDto;
        } else {
            return null;
        }
    }





    private String  generateToken(Long userId, String name, String type, int minutes) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            return JWT.create()
                    .withIssuer("lawfinder.com")
                    .withClaim("userId", userId)
                    .withClaim("type", type)
                    .withClaim("name", name)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000L * 60 * minutes)) // 24 horas
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



}

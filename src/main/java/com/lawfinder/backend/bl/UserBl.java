package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import java.util.*;

import com.lawfinder.backend.services.EmailService;
import com.lawfinder.backend.services.PasswordService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBl {
    @Autowired private LogBl logBl;

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final EmailService emailService;
    private final RoleRepository roleRepository;
    private final VerificationRepository verificationRepository;
    private UserRoleRepository userRoleRepository;


    Logger logger = org.slf4j.LoggerFactory.getLogger(UserBl.class);

    PersonEntity personMemory = new PersonEntity();

    public UserBl(UserRepository userRepository, PersonRepository personRepository,  EmailService emailService,
                  VerificationRepository verificationRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.emailService = emailService;
        this.verificationRepository = verificationRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public void saveCustomer(UserDto userDto, String ipAddress) {
        UserEntity userEntity = new UserEntity();

        // Convert PersonDto to PersonEntity
        PersonDto personDto = userDto.getPersonId();
        PersonEntity person = new PersonEntity();
        personMemory.setPersonId(Long.valueOf(1));
        // Convert AddressDto to AddressEntity

        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setNumber(personDto.getNumber());
        person.setEmail(personDto.getEmail());
        person.setAddress(personDto.getAddress());
        person.setCi(personDto.getCi());
        person.setTx_user("lawfinder");
        person.setTx_date(new java.util.Date());
        person.setTx_host("localhost");
        personMemory = personRepository.save(person);

        // Set properties from userDto to userEntity
        logger.info("username: " + userDto.getUsername());
        userEntity.setUsername(userDto.getUsername());
        //System.out.println("Contraseña" + userDto.getSecret());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setStatus(true);
        userEntity.setPersonId(person);
        //userEntity.setImageId(1);
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());
        userEntity.setIsblocked(true);
       // userEntity.setImageId(1);
        // Save userEntity in the database
        userRepository.save(userEntity);

        // Create UserRoleEntity
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        RoleEntity roleEntity = roleRepository.findByRole("CUSTOMER");
        userRoleEntity.setRole(roleEntity);
        userRoleEntity.setUser(userEntity);
        userRoleEntity.setStatus(true);
        userRoleEntity.setTx_user("lawfinder");
        userRoleEntity.setTx_host("localhost");
        userRoleEntity.setTx_date(new Date());
        userRoleRepository.saveAndFlush(userRoleEntity);
        logBl.saveLog(userDto.getUsername(),
                "Se ha creado un nuevo usuario con id: " + userEntity.getId(),
                1L, ipAddress, 1L);
        emailService.sendEmailMime(userDto.getPersonId().getEmail(),
                "Estado de cuenta",
                "Hola " + userDto.getPersonId().getName() + ",\n\n"
                        + "Tu cuenta ha sido creada exitósamente, sin embargo, un administrador \n" +
                        "debe aprobar tu cuenta para que puedas acceder a la plataforma.\n\n");

    }

    @Transactional
    public void saveLawyer(UserDto userDto, String ipAddress) {
        UserEntity userEntity = new UserEntity();

        // Convert PersonDto to PersonEntity
        PersonDto personDto = userDto.getPersonId();
        PersonEntity person = new PersonEntity();
        personMemory.setPersonId(Long.valueOf(1));
        // Convert AddressDto to AddressEntity

        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setNumber(personDto.getNumber());
        person.setEmail(personDto.getEmail());
        person.setAddress(personDto.getAddress());
        person.setCi(personDto.getCi());
        person.setTx_user("lawfinder");
        person.setTx_date(new java.util.Date());
        person.setTx_host("localhost");
        personMemory = personRepository.save(person);

        // Set properties from userDto to userEntity
        logger.info("username: " + userDto.getUsername());

        userEntity.setUsername(userDto.getUsername());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setStatus(true);
        userEntity.setPersonId(person);
        //userEntity.setImageId(1);
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());
        userEntity.setIsblocked(true);
        // userEntity.setImageId(1);
        // Save userEntity in the database
        UserEntity userAux = userRepository.save(userEntity);

        // Create UserRoleEntity
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        RoleEntity roleEntity = roleRepository.findByRole("LAWYER");
        userRoleEntity.setRole(roleEntity);
        userRoleEntity.setUser(userEntity);
        userRoleEntity.setStatus(true);
        userRoleEntity.setTx_user("lawfinder");
        userRoleEntity.setTx_host("localhost");
        userRoleEntity.setTx_date(new Date());
        userRoleRepository.saveAndFlush(userRoleEntity);

        UserEntity user = userRepository.findByUserId(userAux.getId());
        user.setUsername(user.getUsername() + "_" +  userAux.getId());

        userRepository.save(user);
        logBl.saveLog(userDto.getUsername(),
                "Se ha creado un nuevo abogado con id: " + userEntity.getId(),
                1L, ipAddress, 1L);
        emailService.sendEmailMime(userDto.getPersonId().getEmail(),
                "Estado de cuenta",
                "Hola " + userDto.getPersonId().getName() + ",\n\n"
                        + "Tu cuenta ha sido creada exitósamente, sin embargo, un administrador \n" +
                        "debe aprobar tu cuenta para que puedas acceder a la plataforma.\n\n");

        
    }


    public void sendmail(String email, String code) {

        String subject = "Código de verificación de Law Finder";
        String message = "Hola " + email +  ",\n\n"
                + "Gracias por registrarte en LawFinder. Tu código de verificación es: " + code + "\n\n"
                + "Utiliza este código para completar tu registro en LawFinder.\n\n"
                + "¡Bienvenido y que tengas una excelente experiencia con nuestra plataforma!";
        emailService.sendEmailMime(email, subject, message);

        logBl.saveLog(email,
                "Se ha enviado un correo de verificación a: " + email,
                1L, "127.0.0.1", 1L);

    }

    public Boolean verify(DeviceIdDto deviceIdDto) {
        VerificationEntity verificationEntity = verificationRepository.findByDeviceId(deviceIdDto.getDeviceId());
        String codeHash = verificationEntity.getCodeHash();
        return PasswordService.checkPassword(deviceIdDto.getCode(), codeHash);
    }

    public Boolean verifyUserByEmail(DeviceIdDto deviceIdDto) {
        UserEntity userEntity;
        userEntity = userRepository.findByEmail(deviceIdDto.getEmail());
        return userEntity != null;
    }


    @Transactional
    public void saveVerificationEntity(DeviceIdDto deviceIdDto) {
        UUID uuid = UUID.randomUUID();
        String verificationCodeFinal = generateVerificationCode();
        VerificationEntity verificationEntity = new VerificationEntity();
        verificationEntity.setToken(uuid.toString());
        //TODO: cambiar la fecha para que sea en 5 minutos
        Date date = new Date();
        verificationEntity.setExpirationDate(date);
        sendmail(deviceIdDto.getEmail(), verificationCodeFinal);
        //verificationCode = generateVerificationCode();
        String hashedVerificationCode = PasswordService.hashPassword(verificationCodeFinal);
        verificationEntity.setCodeHash(hashedVerificationCode);
        verificationEntity.setVcType(deviceIdDto.getType());
        verificationEntity.setDeviceId(deviceIdDto.getDeviceId());
        System.out.println(verificationEntity.toString());
        this.verificationRepository.save(verificationEntity);


    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Generar código de verificación de 6 dígitos
    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000; // Generar número aleatorio de 6 dígitos
        return String.valueOf(code);
    }

    public List<UserListDto> getUsers(){
        List<UserEntity> userEntities = userRepository.findAllByStatus();
        List<UserListDto> userDtos = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            UserListDto userListDto = new UserListDto();
            userListDto.setId(userEntity.getId());
            userListDto.setUsername(userEntity.getUsername());
            userListDto.setIsblocked(userEntity.getIsblocked());
            userListDto.setRoles(userRoleRepository.findRolesByUserId(userEntity.getId()));
            userDtos.add(userListDto);
        }
        return userDtos;
    }

    //delete user logically
    public void deleteUser(Long userId, String username, String ipAddress){
        UserEntity userEntity = userRepository.findByUserId(userId);
        userEntity.setStatus(false);
        userRepository.save(userEntity);

        logBl.saveLog(username,
                "Se ha eliminado el usuario con id: " + userId,
                2L, ipAddress, 3L);
    }

    //get user roles

    public EditUserDto getUserEditRoles(Long userId){
        UserEntity userEntity = userRepository.findByUserId(userId);
        List<RoleEntity> RoleRepository = roleRepository.findAllActiveRoles()   ;
        //RoleEntity to UserRoleDto
        List<UserRoleDto> allRoles = new ArrayList<>();
        for(RoleEntity roleEntity : RoleRepository){
            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto.setId(roleEntity.getRoleId());
            userRoleDto.setRole(roleEntity.getRoleName());
            allRoles.add(userRoleDto);
        }

        EditUserDto editUserDto = new EditUserDto();
        editUserDto.setId(userEntity.getId());
        editUserDto.setUsername(userEntity.getUsername());
        editUserDto.setEmail(userEntity.getPersonId().getEmail());
        editUserDto.setAllRoles(allRoles);
        List<UserRoleDto> userRoleDtos = new ArrayList<>();
        List<UserRoleEntity> userRoleEntities = userRoleRepository.findByUser_Id(userId);
        for(UserRoleEntity userRoleEntity : userRoleEntities){
            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto.setId(userRoleEntity.getRole().getRoleId());
            userRoleDto.setRole(userRoleEntity.getRole().getRoleName());
            userRoleDtos.add(userRoleDto);
        }
        editUserDto.setRoles(userRoleDtos);

        return editUserDto;
    }

    public void updateUser(Long id ,UserDto userDto, String username, String ipAddress){
        UserEntity userEntity = userRepository.findByUserId(id);
        userEntity.setUsername(userDto.getUsername());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());
        userRepository.save(userEntity);
        logBl.saveLog(username,
                "Se ha actualizado el usuario con id: " + id,
                2L, ipAddress, 2L);

    }

    final private TreeMap<UUID, String> passwordResetRequests = new TreeMap<>();
    public void resetPassword(String email, String ipAddress) {
        PersonEntity personEntity = personRepository.findByEmail(email);
        try{
            Long personId = personEntity.getPersonId();
            UserEntity userEntity = userRepository.findByPersonId(personId);
            UUID uuid = UUID.randomUUID();
            passwordResetRequests.put(uuid, email);
            emailService.sendEmailMime(email,
                    "Restablecimiento de contraseña",
                    "Hola " + userEntity.getPersonId().getName() + ",\n\n"
                            + "Hemos recibido una solicitud para restablecer tu contraseña. Haz clic en el siguiente enlace para restablecer tu contraseña: \n\n" +
                            "http://localhost:5173/ResetPassword?uuid=" + uuid + "\n\n"
                            + "Si no solicitaste restablecer tu contraseña, ignora este mensaje.");

            logBl.saveSecurityLog(email,
                    "Se ha enviado un correo de restablecimiento de contraseña a: " + email,
                    ipAddress, 4L);
        }catch (Exception e){
            throw new IllegalArgumentException("No se encontró el usuario con el correo electrónico proporcionado.");
        }
    }

    public void changePassword(UUID passwordResetToken, String newPassword) {
        if(passwordResetRequests.containsKey(passwordResetToken)) {
            String email = passwordResetRequests.get(passwordResetToken);
            passwordResetRequests.remove(passwordResetToken);
            UserEntity userEntity = userRepository.findByEmail(email);
            userEntity.setSecret(PasswordService.hashPassword(newPassword));
            userRepository.save(userEntity);

            emailService.sendEmailMime(email,
                    "Contraseña restablecida",
                    "Hola " + userEntity.getPersonId().getName() + ",\n\n"
                            + "Tu contraseña ha sido restablecida exitósamente.\n\n" +
                            "Si tu no solicitaste restablecer tu contraseña, por favor contacta con el administrador.");
            logBl.saveSecurityLog(email,
                    "Se ha restablecido la contraseña del usuario con email: " + email,
                    "127.0.0.1", 2L);
        } else {
            throw new IllegalArgumentException("token de restablecimiento de contraseña no válido.");
        }


    }
}

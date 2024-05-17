package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import java.util.*;

import com.lawfinder.backend.services.EmailService;
import com.lawfinder.backend.services.PasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBl {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final EmailService emailService;
    private final RoleRepository roleRepository;
    private final VerificationRepository verificationRepository;
    private UserRoleRepository userRoleRepository;


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
    public void saveCustomer(UserDto userDto) {
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

    }

    @Transactional
    public void saveLawyer(UserDto userDto) {
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
        user.setUsername(person.getName() + "_" + person.getLastname() + "_" + userAux.getId());
        userRepository.save(user);
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
    public void deleteUser(Long userId){
        UserEntity userEntity = userRepository.findByUserId(userId);
        userEntity.setStatus(false);
        userRepository.save(userEntity);
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

    public void updateUser(Long id ,UserDto userDto){
        UserEntity userEntity = userRepository.findByUserId(id);
        userEntity.setUsername(userDto.getUsername());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());
        userRepository.save(userEntity);


    }










}

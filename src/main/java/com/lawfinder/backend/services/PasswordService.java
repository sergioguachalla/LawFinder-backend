package com.lawfinder.backend.services;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}

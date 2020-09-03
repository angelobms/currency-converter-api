package tech.jaya.currencyconverter.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate a hash using BCrypt library.
 *
 * @author angelo santos
 * @version 1.0
 * @since 29/08/2020
 */
@Slf4j
public class PasswordUtil {

    /**
     * Method responsible for encrypting the user's password using the BCrypt library.
     *
     * @param password User password
     * @return String
     */
    public static String createHash(String password) {

        log.info("Encrypting user password...");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordHash = bCryptPasswordEncoder.encode(password);

        log.info("Encrypted user password: {}", passwordHash);

        return  passwordHash;
    }
}

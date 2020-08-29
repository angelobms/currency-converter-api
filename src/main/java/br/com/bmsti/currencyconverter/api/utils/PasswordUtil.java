package br.com.bmsti.currencyconverter.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate a hash using BCrypt library.
 *
 * @author angelo santos
 * @version 1.0
 * @since 28/08/2020
 */
public class PasswordUtil {

    private static final Logger log = LoggerFactory.getLogger(PasswordUtil.class);

    public PasswordUtil() {
    }

    /**
     * Method responsible for encrypting the user's password using the BCrypt library.
     *
     * @param password
     * @return String
     */
    public static String createHash(String password) {

        log.info("Encrypting user password...");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordHash = bCryptPasswordEncoder.encode(password);

        log.info("Encrypted user password.");

        return  passwordHash;
    }
}

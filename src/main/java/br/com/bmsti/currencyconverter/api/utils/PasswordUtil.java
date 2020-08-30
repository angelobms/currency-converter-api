package br.com.bmsti.currencyconverter.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate a hash using BCrypt library.
 *
 * @author angelo santos
 * @version 1.0
 * @since 29/08/2020
 */
public class PasswordUtil {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    /**
     * Method responsible for encrypting the user's password using the BCrypt library.
     *
     * @param password User password
     * @return String
     */
    public static String createHash(String password) {

        LOG.info("Encrypting user password...");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordHash = bCryptPasswordEncoder.encode(password);

        LOG.info("Encrypted user password: {}", passwordHash);

        return  passwordHash;
    }
}

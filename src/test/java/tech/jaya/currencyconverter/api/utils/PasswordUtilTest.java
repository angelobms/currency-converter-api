package tech.jaya.currencyconverter.api.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    private static final String PASSWORD = "123456";
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void shouldGenerateHashPassword() {
        LOG.info("Executing 'shouldGenerateHashPassword' password util test");
        String hash = PasswordUtil.createHash(PASSWORD);
        assertTrue(bCryptPasswordEncoder.matches(PASSWORD, hash));
    }
}

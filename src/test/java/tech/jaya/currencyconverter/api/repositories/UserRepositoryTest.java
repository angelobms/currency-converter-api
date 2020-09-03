package tech.jaya.currencyconverter.api.repositories;

import tech.jaya.currencyconverter.api.entities.User;
import tech.jaya.currencyconverter.api.enums.ProfileType;
import tech.jaya.currencyconverter.api.utils.PasswordUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    @Autowired
    private UserRepository userRepository;

    private static final String EMAIL = "admin@jaya.com";

    @BeforeEach
    public void setUp() {
        LOG.info("Startup test");

        User user = new User();
        user.setEmail(EMAIL);
        user.setPassword(PasswordUtil.createHash("123456"));
        user.setProfile(ProfileType.ROLE_USER);
        this.userRepository.save(user);
    }

    @AfterEach
    public void tearDown() {
        LOG.info("Finalize test");

        this.userRepository.deleteAll();
    }

    @Test
    public void shouldFindByEmail() {
        LOG.info("Executing 'shouldFindByEmail' test");

        User user = this.userRepository.findByEmail(EMAIL);

        assertEquals(EMAIL, user.getEmail());
    }
}

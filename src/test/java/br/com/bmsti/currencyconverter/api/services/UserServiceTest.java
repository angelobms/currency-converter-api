package br.com.bmsti.currencyconverter.api.services;

import br.com.bmsti.currencyconverter.api.entities.User;
import br.com.bmsti.currencyconverter.api.repositories.UserRepository;
import br.com.bmsti.currencyconverter.api.utils.PasswordUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@SpringBootTest
public class UserServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    private static final Long ID = 1L;
    private static final String EMAIL = "test@test.com";

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        BDDMockito.given(this.userRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new User()));
        BDDMockito.given(this.userRepository.findByEmail(Mockito.anyString())).willReturn(new User());
    }

    @Test
    public void shouldFindUserById() {
        LOG.info("Executing 'shouldFindUserById' user service test");
        Optional<User> user = this.userService.findById(ID);

        assertTrue(user.isPresent());
    }

    @Test
    public void shouldFindUserByEmail() {
        LOG.info("Executing 'shouldFindUserByEmail' user service test");
        Optional<User> user = this.userService.findByEmail(EMAIL);

        assertTrue(user.isPresent());
    }
}

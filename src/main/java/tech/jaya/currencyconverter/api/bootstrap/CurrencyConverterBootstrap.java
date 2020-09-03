package tech.jaya.currencyconverter.api.bootstrap;

import tech.jaya.currencyconverter.api.entities.User;
import tech.jaya.currencyconverter.api.enums.ProfileType;
import tech.jaya.currencyconverter.api.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Currency Converter Bootstrap
 *
 * @author angelo santos
 * @version 1.0
 * @since 01/09/2020
 */
@Slf4j
@Profile("test")
@Component
public class CurrencyConverterBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    public CurrencyConverterBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method responsible for executing events in the application.
     *
     * @param event event
     */
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userRepository.saveAll(getUsers());
        log.debug("Loading Bootstrap Data");
    }

    /**
     * Method responsible for returning a list of users.
     *
     * @return List<User>
     */
    private List<User> getUsers() {

        List<User> users = new ArrayList<User>(2);

        User user = new User();
        user.setId(1L);
        user.setEmail("user@jaya.com");
        user.setPassword("$2a$10$8ubI9YIkIGrJsTUSZDege.J9jnTTMUizHB92c2Y0H4Kc2MUSbxuPy");
        user.setProfile(ProfileType.ROLE_USER);
        user.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        user.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        users.add(user);

        User userAdmin = new User();
        userAdmin.setId(2L);
        userAdmin.setEmail("admin@jayatech.net.br");
        userAdmin.setPassword("$2a$10$8ubI9YIkIGrJsTUSZDege.J9jnTTMUizHB92c2Y0H4Kc2MUSbxuPy");
        userAdmin.setProfile(ProfileType.ROLE_USER);
        userAdmin.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        userAdmin.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        users.add(userAdmin);

        return users;
    }
}

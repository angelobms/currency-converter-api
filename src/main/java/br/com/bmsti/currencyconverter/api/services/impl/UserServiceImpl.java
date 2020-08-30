package br.com.bmsti.currencyconverter.api.services.impl;

import br.com.bmsti.currencyconverter.api.entities.User;
import br.com.bmsti.currencyconverter.api.repositories.UserRepository;
import br.com.bmsti.currencyconverter.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        LOG.info("Searching for a user by ID {}", id);
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        LOG.info("Searching for a user by email {}", email);
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }
}

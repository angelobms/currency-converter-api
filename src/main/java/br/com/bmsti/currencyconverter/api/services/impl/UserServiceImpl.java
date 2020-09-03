package br.com.bmsti.currencyconverter.api.services.impl;

import br.com.bmsti.currencyconverter.api.converters.UserConverter;
import br.com.bmsti.currencyconverter.api.dtos.UserDTO;
import br.com.bmsti.currencyconverter.api.entities.User;
import br.com.bmsti.currencyconverter.api.repositories.UserRepository;
import br.com.bmsti.currencyconverter.api.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User service class
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method responsible for fetching a user by id
     *
     * @param id user id
     * @return UserDTO
     */
    @Override
    public UserDTO findById(Long id) {
        log.info("Searching for a user by ID {}", id);
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        return UserConverter.contertTo(user);
    }

    /**
     * Method responsible for fetching a user by email
     *
     * @param email user email
     * @return UserDTO
     */
    @Override
    public UserDTO findByEmail(String email) {
        log.info("Searching for a user by email {}", email);
        User user = Optional.ofNullable(this.userRepository.findByEmail(email)).orElseThrow(() -> new RuntimeException("User not found!"));

        return UserConverter.contertTo(user);
    }
}

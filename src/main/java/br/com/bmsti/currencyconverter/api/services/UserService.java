package br.com.bmsti.currencyconverter.api.services;

import br.com.bmsti.currencyconverter.api.dtos.UserDTO;

/**
 * Class interface service user
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
public interface UserService {

    /**
     * Method responsible for searching for user by email.
     *
     * @param id user id
     * @return Optional<User>
     */
    UserDTO findById(Long id);

    /**
     * Method responsible for searching for user by email.
     *
     * @param email user email
     * @return Optional<User>
     */
    UserDTO findByEmail(String email);

}

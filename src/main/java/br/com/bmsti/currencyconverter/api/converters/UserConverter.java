package br.com.bmsti.currencyconverter.api.converters;

import br.com.bmsti.currencyconverter.api.dtos.UserDTO;
import br.com.bmsti.currencyconverter.api.entities.User;

/**
 * Class converter user
 *
 * @author angelo santos
 * @version 1.0
 * @since 31/08/2020
 */
public class UserConverter {

    /**
     * Method responsible for converting a user to a data transaction object
     *
     * @param userDTO user Data Transfer Object
     * @return User
     */
    public static User contertTo(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setProfile(userDTO.getProfile());

        return user;
    }

     /**
     * Method responsible for converting a data transaction object to a transaction
     *
     * @param user user
     * @return UserDTO
     */
    public static UserDTO contertTo(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setProfile(user.getProfile());

        return userDTO;
    }

}

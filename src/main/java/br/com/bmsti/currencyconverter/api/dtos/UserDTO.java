package br.com.bmsti.currencyconverter.api.dtos;

import br.com.bmsti.currencyconverter.api.enums.ProfileType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User Data Transaction Object
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    @Email
    private String email;

    private String password;

    @NotNull
    private ProfileType profile;

}

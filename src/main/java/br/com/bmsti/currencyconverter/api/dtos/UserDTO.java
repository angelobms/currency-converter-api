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
public class UserDTO {

    private Long id;

    @NotBlank
    @Email
    private String email;

    private String password;

    @NotNull
    private ProfileType profile;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileType getProfile() {
        return profile;
    }

    public void setProfile(ProfileType profile) {
        this.profile = profile;
    }
}

package pl.mzlnk.emergencyspotapi.model.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String firstName;
    private String lastName;
    private String pesel;

}

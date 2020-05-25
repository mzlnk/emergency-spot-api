package pl.mzlnk.emergencyspotapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String pesel;

    private String username;
    private String password;

}

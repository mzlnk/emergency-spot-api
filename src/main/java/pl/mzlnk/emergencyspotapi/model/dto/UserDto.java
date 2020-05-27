package pl.mzlnk.emergencyspotapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String pesel;

    private String username;

    @JsonIgnore
    private String password;

}

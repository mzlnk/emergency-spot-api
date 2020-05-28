package pl.mzlnk.emergencyspotapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();

        dto.firstName = user.getHospitalPatient().getFirstName();
        dto.lastName = user.getHospitalPatient().getLastName();
        dto.pesel = user.getHospitalPatient().getPesel();

        return dto;
    }

    private String firstName;
    private String lastName;
    private String pesel;

    private String username;

    // todo: set access property
    private String password;

}

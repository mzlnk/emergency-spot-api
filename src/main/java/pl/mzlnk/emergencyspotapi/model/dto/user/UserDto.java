package pl.mzlnk.emergencyspotapi.model.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.entity.User;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();

        dto.username = user.getUsername();
        dto.firstName = user.getHospitalPatient().getFirstName();
        dto.lastName = user.getHospitalPatient().getLastName();
        dto.pesel = user.getHospitalPatient().getPesel();

        return dto;
    }

    private String username;
    private String firstName;
    private String lastName;
    private String pesel;

}

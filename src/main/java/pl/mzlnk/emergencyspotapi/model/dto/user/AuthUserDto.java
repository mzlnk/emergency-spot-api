package pl.mzlnk.emergencyspotapi.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUserDto {

    private Long patientId;
    private String username;
    private String token;

}

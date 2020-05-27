package pl.mzlnk.emergencyspotapi.model.dto.hospitalward;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;

@Data
public class NewHospitalWardDto {

    private Long hospitalId;
    private HospitalWardTypeEnum wardType;

    private Long capacity;

}

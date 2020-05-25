package pl.mzlnk.emergencyspotapi.model.dto.hospitalward;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;

@Data
public class HospitalWardDto {

    private HospitalDto hospital;
    private HospitalWardEnum wardType;

}

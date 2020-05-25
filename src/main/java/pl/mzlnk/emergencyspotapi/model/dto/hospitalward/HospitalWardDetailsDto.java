package pl.mzlnk.emergencyspotapi.model.dto.hospitalward;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;

@Data
public class HospitalWardDetailsDto {

    private HospitalDto hospital;
    private HospitalWardTypeEnum wardType;

    private Long capacity;
    private Long currentPatients;

    private Double averageRating;

}

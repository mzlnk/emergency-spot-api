package pl.mzlnk.emergencyspotapi.model.dto.hospitalward;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;

@Data
public class HospitalWardDetailsDto {

    private HospitalDto hospital;
    private HospitalWardEnum wardType;

    private Long capacity;
    private Long currentPatients;

    private Double averageRating;

}

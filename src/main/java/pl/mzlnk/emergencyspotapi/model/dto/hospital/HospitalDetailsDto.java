package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;

import java.util.List;

@Data
public class HospitalDetailsDto {

    private String name;
    private String description;
    private AddressDto address;
    private Double averageRating;
    private List<HospitalWardDto> wards;

}

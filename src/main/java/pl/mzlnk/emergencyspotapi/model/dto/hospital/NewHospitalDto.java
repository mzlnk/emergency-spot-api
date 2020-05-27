package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.Data;

@Data
public class NewHospitalDto {

    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private AddressDto address;

}

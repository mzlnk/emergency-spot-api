package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.Data;

@Data
public class HospitalDto {

    private String name;
    private String description;
    private AddressDto address;

}

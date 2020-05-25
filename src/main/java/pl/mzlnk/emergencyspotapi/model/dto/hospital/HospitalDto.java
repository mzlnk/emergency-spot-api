package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;

@Data
@AllArgsConstructor
public class HospitalDto {

    private Long id;
    private String name;
    private String description;
    private AddressDto address;

    public HospitalDto(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.description = hospital.getDescription();
        this.address = new AddressDto(hospital.getAddress());
    }

}

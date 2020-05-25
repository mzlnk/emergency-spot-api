package pl.mzlnk.emergencyspotapi.model.dto.hospitalward;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;

@Data
@AllArgsConstructor
public class HospitalWardDto {

    private HospitalDto hospital;
    private HospitalWardTypeEnum wardType;

    public HospitalWardDto(HospitalWard hospitalWard) {
        this.hospital = new HospitalDto(hospitalWard.getHospital());
        this.wardType = hospitalWard.getWardType();
    }

}

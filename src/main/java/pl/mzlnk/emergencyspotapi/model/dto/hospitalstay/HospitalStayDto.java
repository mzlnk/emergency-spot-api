package pl.mzlnk.emergencyspotapi.model.dto.hospitalstay;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HospitalStayDto {

    public static HospitalStayDto fromEntity(HospitalStay hospitalStay) {
        HospitalStayDto dto = new HospitalStayDto();

        dto.id = hospitalStay.getId();
        dto.ward = HospitalWardDto.fromEntity(hospitalStay.getHospitalWard());
        dto.dateFrom = hospitalStay.getDateFrom();
        dto.dateTo = hospitalStay.getDateTo();

        return dto;
    }

    private Long id;
    private HospitalWardDto ward;

    private Calendar dateFrom;
    private Calendar dateTo;

}

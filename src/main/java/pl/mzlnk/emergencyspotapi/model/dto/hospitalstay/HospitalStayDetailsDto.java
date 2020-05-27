package pl.mzlnk.emergencyspotapi.model.dto.hospitalstay;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HospitalStayDetailsDto {

    public static HospitalStayDetailsDto fromEntity(HospitalStay hospitalStay) {
        HospitalStayDetailsDto dto = new HospitalStayDetailsDto();

        dto.id = hospitalStay.getId();
        dto.ward = HospitalWardDto.fromEntity(hospitalStay.getHospitalWard());
        dto.dateFrom = hospitalStay.getDateFrom();
        dto.dateTo = hospitalStay.getDateTo();
        dto.review = HospitalReviewDto.fromEntity(hospitalStay.getHospitalReview());

        return dto;
    }

    private Long id;
    private HospitalWardDto ward;

    private Calendar dateFrom;
    private Calendar dateTo;

    private HospitalReviewDto review;

}

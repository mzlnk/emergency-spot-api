package pl.mzlnk.emergencyspotapi.model.dto.hospitalstay;

import java.util.Calendar;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;

@Data
public class HospitalStayDetailsDto {

    private HospitalWardDto ward;

    private Calendar dateFrom;
    private Calendar dateTo;

    private HospitalReviewDto review;

}

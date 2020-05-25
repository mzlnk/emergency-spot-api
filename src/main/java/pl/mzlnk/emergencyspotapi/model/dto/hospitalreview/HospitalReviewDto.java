package pl.mzlnk.emergencyspotapi.model.dto.hospitalreview;

import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;

@Data
public class HospitalReviewDto {

    private HospitalWardDto ward;
    private Double rating;

}

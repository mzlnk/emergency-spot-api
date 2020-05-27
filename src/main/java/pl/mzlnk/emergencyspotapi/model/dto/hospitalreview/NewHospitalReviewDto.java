package pl.mzlnk.emergencyspotapi.model.dto.hospitalreview;

import lombok.Data;

@Data
public class NewHospitalReviewDto {

    private Double rating;
    private Long hospitalWardId;
    private Long hospitalStayId;

}

package pl.mzlnk.emergencyspotapi.model.dto.hospitalreview;

import lombok.Data;

@Data
public class NewHospitalReviewDto {

    private Long hospitalStayId;
    private Double rating;

}

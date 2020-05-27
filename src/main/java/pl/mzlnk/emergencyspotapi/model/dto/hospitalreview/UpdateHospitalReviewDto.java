package pl.mzlnk.emergencyspotapi.model.dto.hospitalreview;

import lombok.Data;

@Data
public class UpdateHospitalReviewDto {

    private Long hospitalReviewId;
    private Double newRating;

}

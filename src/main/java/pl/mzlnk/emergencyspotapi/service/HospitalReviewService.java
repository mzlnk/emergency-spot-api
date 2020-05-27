package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.NewHospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalReview;

public interface HospitalReviewService extends EntityService<HospitalReviewDto, HospitalReviewDetailsDto, NewHospitalReviewDto, HospitalReview> {

}

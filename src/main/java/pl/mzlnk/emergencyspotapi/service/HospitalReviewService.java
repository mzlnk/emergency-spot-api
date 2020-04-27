package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;

import java.util.List;
import java.util.Optional;

public interface HospitalReviewService {

    List<HospitalReview> findAll(HospitalReviewParams params);

    Optional<HospitalReview> findOne(Long id);

    void createOrUpdate(HospitalReview hospitalReview);

    void delete(HospitalReview hospitalReview);

    void deleteById(long id);

}

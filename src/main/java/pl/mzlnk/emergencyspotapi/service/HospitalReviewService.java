package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.HospitalReview;

import java.util.List;
import java.util.Optional;

public interface HospitalReviewService {

    List<HospitalReview> findAll();
    List<HospitalReview> findByHospital(long hospitalId);

    Optional<HospitalReview> findById(long id);

    void createOrUpdate(HospitalReview hospitalReview);

    void delete(HospitalReview hospitalReview);
    void deleteById(long id);

}

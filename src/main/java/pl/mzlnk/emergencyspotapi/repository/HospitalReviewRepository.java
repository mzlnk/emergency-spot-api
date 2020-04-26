package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalReview;

import java.util.List;

public interface HospitalReviewRepository extends CrudRepository<HospitalReview, Long> {

    List<HospitalReview> findByHospital(Hospital hospital);


}

package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalReview;

@Repository
public interface HospitalReviewRepository extends JpaRepository<HospitalReview, Long> {

}

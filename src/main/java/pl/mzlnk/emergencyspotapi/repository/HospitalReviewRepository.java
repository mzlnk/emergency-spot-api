package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalReview;

import java.util.List;

@Repository
public interface HospitalReviewRepository extends CrudRepository<HospitalReview, Long> {

    List<HospitalReview> findAll(Example<HospitalReview> example);

}

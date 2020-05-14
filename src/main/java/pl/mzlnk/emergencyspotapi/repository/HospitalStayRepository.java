package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalStay;

@Repository
public interface HospitalStayRepository extends JpaRepository<HospitalStay, Long> {

}

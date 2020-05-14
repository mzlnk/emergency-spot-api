package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalPatient;

@Repository
public interface HospitalPatientRepository extends JpaRepository<HospitalPatient, Long> {


}

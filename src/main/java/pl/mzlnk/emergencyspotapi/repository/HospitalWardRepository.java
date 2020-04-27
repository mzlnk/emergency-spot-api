package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;

@Repository
public interface HospitalWardRepository extends JpaRepository<HospitalWard, Long> {

}

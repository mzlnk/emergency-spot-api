package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;

import java.util.List;

@Repository
public interface HospitalWardRepository extends JpaRepository<HospitalWard, Long> {

}

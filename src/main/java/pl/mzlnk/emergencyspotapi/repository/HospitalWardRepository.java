package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;

import java.util.List;

public interface HospitalWardRepository extends CrudRepository<HospitalWard, Long> {

    List<HospitalWard> findByWardType(HospitalWardTypeEnum wardType);
    List<HospitalWard> findByHospital(Hospital hospital);

}

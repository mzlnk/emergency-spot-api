package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;

import java.util.List;
import java.util.Optional;

public interface HospitalWardService {

    List<HospitalWard> findAll();
    List<HospitalWard> findByWardType(HospitalWardTypeEnum wardType);
    List<HospitalWard> findByHospital(long hospitalId);

    Optional<HospitalWard> findById(long id);

    void createOrUpdate(HospitalWard hospitalWard);

    void delete(HospitalWard hospitalWard);
    void deleteById(long id);

}

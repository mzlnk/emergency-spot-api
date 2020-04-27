package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;

import java.util.List;
import java.util.Optional;

public interface HospitalWardService {

    List<HospitalWard> findAll(HospitalWardParams params);

    Optional<HospitalWard> findOne(Long id);

    void createOrUpdate(HospitalWard hospitalWard);

    void delete(HospitalWard hospitalWard);

    void deleteById(long id);

}

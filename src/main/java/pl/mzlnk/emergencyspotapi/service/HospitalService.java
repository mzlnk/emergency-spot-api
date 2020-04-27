package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.params.HospitalParams;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    List<Hospital> findAll(HospitalParams params);

    Optional<Hospital> findOne(Long id);

    Optional<Hospital> findNearest(double longitude, double latitude);

    void createOrUpdate(Hospital hospital);

    void delete(Hospital hospital);

    void deleteById(long id);

}

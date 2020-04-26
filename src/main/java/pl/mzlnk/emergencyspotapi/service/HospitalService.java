package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    List<Hospital> findAll();

    List<Hospital> findByCountry(String country);
    List<Hospital> findByCity(String city);
    List<Hospital> findByWardType(HospitalWardTypeEnum wardType);

    Optional<Hospital> findById(long id);
    Optional<Hospital> findByName(String name);
    Optional<Hospital> findByCoordinates(double longitude, double latitude);

    Optional<Hospital> findNearest(double longitude, double latitude);

    void createOrUpdate(Hospital hospital);

    void delete(Hospital hospital);
    void deleteById(long id);

}

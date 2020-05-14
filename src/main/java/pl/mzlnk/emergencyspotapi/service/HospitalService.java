package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.entity.Hospital;

import java.util.Optional;

public interface HospitalService extends EntityService<Hospital> {

    Optional<Hospital> findNearest(double longitude, double latitude);

}

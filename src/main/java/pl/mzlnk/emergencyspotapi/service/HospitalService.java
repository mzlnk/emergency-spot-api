package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.params.HospitalParams;

import java.util.List;
import java.util.Optional;

public interface HospitalService extends EntityService<Hospital> {

    Optional<Hospital> findNearest(double longitude, double latitude);

}

package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;

import java.util.Optional;

public interface HospitalService extends EntityService<HospitalDto, Hospital> {

    Optional<HospitalDto> findNearest(double longitude, double latitude);

}

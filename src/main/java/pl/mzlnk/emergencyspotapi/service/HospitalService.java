package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.NewHospitalDto;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;

import java.util.Optional;

public interface HospitalService extends EntityService<HospitalDto, HospitalDetailsDto, NewHospitalDto, Hospital> {

    Optional<HospitalDetailsDto> findNearest(double longitude, double latitude);

}

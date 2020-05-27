package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.NewHospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;

public interface HospitalStayService extends EntityService<HospitalStayDto, HospitalStayDetailsDto, NewHospitalStayDto, HospitalStay> {


}

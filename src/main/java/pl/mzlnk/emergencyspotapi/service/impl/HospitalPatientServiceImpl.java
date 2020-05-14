package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.repository.HospitalPatientRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalPatientService;

@Service
@AllArgsConstructor
public class HospitalPatientServiceImpl implements HospitalPatientService {

    private final HospitalPatientRepository hospitalPatientRepository;



}

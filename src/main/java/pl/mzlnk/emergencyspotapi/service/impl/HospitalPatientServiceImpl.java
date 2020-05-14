package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalPatient;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalPatientRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalPatientService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalPatientServiceImpl implements HospitalPatientService {

    private final HospitalPatientRepository hospitalPatientRepository;

    @Override
    public List<HospitalPatient> findAll(EntityParams<HospitalPatient> params) {
        return hospitalPatientRepository.findAll(params.toExample());
    }

    @Override
    public Optional<HospitalPatient> findOne(Long id) {
        return hospitalPatientRepository.findById(id);
    }

    @Override
    public void createOrUpdate(HospitalPatient entity) {
        hospitalPatientRepository.save(entity);
    }

    @Override
    public void delete(HospitalPatient entity) {
        hospitalPatientRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        hospitalPatientRepository.deleteById(id);
    }

}

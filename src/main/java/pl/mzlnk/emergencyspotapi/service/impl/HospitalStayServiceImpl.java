package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalStayRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalStayServiceImpl implements HospitalStayService {

    private final HospitalStayRepository hospitalStayRepository;

    @Override
    public List<HospitalStay> findAll(EntityParams<HospitalStay> params) {
        HospitalStayParams hospitalStayParams = (HospitalStayParams) params;
        return hospitalStayRepository.findHospitalStaysByDateFromAfterAndDateToBefore(hospitalStayParams.dateFrom, hospitalStayParams.dateTo);
    }

    @Override
    public Optional<HospitalStay> findOne(Long id) {
        return hospitalStayRepository.findById(id);
    }

    @Override
    public void createOrUpdate(HospitalStay entity) {
        hospitalStayRepository.save(entity);
    }

    @Override
    public void delete(HospitalStay entity) {
        hospitalStayRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        hospitalStayRepository.deleteById(id);
    }

}

package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.AddressDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalWardRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalService;
import pl.mzlnk.emergencyspotapi.service.HospitalWardService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalWardServiceImpl implements HospitalWardService {

    private final HospitalWardRepository hospitalWardRepository;
    private final Logger logger;

    @Override
    public List<HospitalWardDto> findAll(EntityParams<HospitalWard> params) {
        return hospitalWardRepository
                .findAll(params.toExample())
                .stream()
                .filter(ward -> ward.getCapacity() >= ((HospitalWardParams) params).minCapacity)
                .filter(ward -> ward.getCapacity() <= ((HospitalWardParams) params).maxCapacity)
                .map(HospitalWardDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HospitalWardDto> findOne(Long id) {
        return hospitalWardRepository
                .findById(id)
                .map(HospitalWardDto::new);
    }

    @Override
    public void createOrUpdate(HospitalWardDto hospitalWard) {
        // hospitalWardRepository.save(hospitalWard);
    }

    @Override
    public void delete(HospitalWardDto hospitalWard) {
        // hospitalWardRepository.delete(hospitalWard);
    }

    @Override
    public void deleteById(Long id) {
        hospitalWardRepository.deleteById(id);
    }

}

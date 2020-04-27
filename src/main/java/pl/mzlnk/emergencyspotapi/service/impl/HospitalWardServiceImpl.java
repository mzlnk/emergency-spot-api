package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalWardRepository;
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
    public List<HospitalWard> findAll(HospitalWardParams params) {
        return hospitalWardRepository
                .findAll(params.toExample())
                .stream()
                .filter(ward -> ward.getCapacity() >= params.minCapacity)
                .filter(ward -> ward.getCapacity() <= params.maxCapacity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HospitalWard> findOne(Long id) {
        return hospitalWardRepository.findById(id);
    }

    @Override
    public void createOrUpdate(HospitalWard hospitalWard) {
        hospitalWardRepository.save(hospitalWard);
    }

    @Override
    public void delete(HospitalWard hospitalWard) {
        hospitalWardRepository.delete(hospitalWard);
    }

    @Override
    public void deleteById(long id) {
        hospitalWardRepository.deleteById(id);
    }

}

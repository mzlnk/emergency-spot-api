package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.AddressDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalService;
import pl.mzlnk.emergencyspotapi.utils.distance.Coordinates;
import pl.mzlnk.emergencyspotapi.utils.distance.DistanceUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final DistanceUtils distanceUtils;

    @Override
    public List<HospitalDto> findAll(EntityParams<Hospital> params) {
        List<Hospital> result = hospitalRepository.findAll(params.toExample());

        HospitalParams hospitalParams = (HospitalParams) params;
        if (!hospitalParams.wards.isEmpty()) {
            result = result
                    .stream()
                    .filter(hospital ->
                            hospital.getWards()
                                    .stream()
                                    .map(HospitalWard::getWardType)
                                    .anyMatch(hospitalParams.wards::contains))
                    .collect(Collectors.toList());
        }

        return result
                .stream()
                .map(HospitalDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HospitalDto> findOne(Long id) {
        return hospitalRepository
                .findById(id)
                .map(HospitalDto::new);
    }

    @Override
    public Optional<HospitalDto> findNearest(double longitude, double latitude) {
        Coordinates coords = new Coordinates(longitude, latitude);

        return StreamSupport.stream(hospitalRepository.findAll().spliterator(), true)
                .map(hospital -> {
                    return new AbstractMap.SimpleEntry<>(
                            hospital,
                            distanceUtils.calculateDistance(coords, Coordinates.fromHospital(hospital))
                    );
                })
                .min(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue))
                .map(Map.Entry::getKey)
                .map(HospitalDto::new);
    }

    @Override
    public void createOrUpdate(HospitalDto hospital) {
        // todo: code here
    }

    @Override
    public void delete(HospitalDto hospital) {
        // todo: code here
    }

    @Override
    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }

}

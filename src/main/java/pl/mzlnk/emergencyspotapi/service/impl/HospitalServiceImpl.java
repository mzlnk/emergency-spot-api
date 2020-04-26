package pl.mzlnk.emergencyspotapi.service.impl;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.repository.HospitalRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalService;
import pl.mzlnk.emergencyspotapi.utils.distance.Coordinates;
import pl.mzlnk.emergencyspotapi.utils.distance.DistanceUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> findAll() {
        return IterableUtils.toList(hospitalRepository.findAll());
    }

    @Override
    public List<Hospital> findByCountry(String country) {
        return IterableUtils.toList(hospitalRepository.findByCountry(country));
    }

    @Override
    public List<Hospital> findByCity(String city) {
        return IterableUtils.toList(hospitalRepository.findByCity(city));
    }

    @Override
    public List<Hospital> findByWardType(HospitalWardTypeEnum wardType) {
        return StreamSupport.stream(hospitalRepository.findAll().spliterator(), true)
                .filter(hospital -> {
                    return hospital.getWards()
                            .stream()
                            .map(HospitalWard::getWardType)
                            .anyMatch(type -> type.equals(wardType));
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Hospital> findById(long id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public Optional<Hospital> findByName(String name) {
        return hospitalRepository.findByName(name);
    }

    @Override
    public Optional<Hospital> findByCoordinates(double longitude, double latitude) {
        return hospitalRepository.findByLongitudeAndLatitude(longitude, latitude);
    }

    @Override
    public Optional<Hospital> findNearest(double longitude, double latitude) {
        Coordinates coords = new Coordinates(longitude, latitude);

        return StreamSupport.stream(hospitalRepository.findAll().spliterator(), true)
                .map(hospital -> {
                    return new AbstractMap.SimpleEntry<>(
                            hospital,
                            DistanceUtils.calculateDistance(coords, Coordinates.fromHospital(hospital))
                    );
                })
                .min(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue))
                .map(Map.Entry::getKey);
    }

    @Override
    public void createOrUpdate(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void delete(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }

    @Override
    public void deleteById(long id) {

    }
}

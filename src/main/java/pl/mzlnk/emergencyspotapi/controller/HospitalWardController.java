package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;
import pl.mzlnk.emergencyspotapi.service.HospitalService;
import pl.mzlnk.emergencyspotapi.service.HospitalWardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wards")
@AllArgsConstructor
public class HospitalWardController {

    private final HospitalWardService hospitalWardService;
    private final HospitalService hospitalService;

    @GetMapping
    public List<HospitalWard> findAll(@RequestParam(required = false, name = "ward") HospitalWardTypeEnum wardType,
                                      @RequestParam(required = false, name = "min_capacity", defaultValue = "0") Integer minCapacity,
                                      @RequestParam(required = false, name = "max_capacity", defaultValue = "2147483647") Integer maxCapacity,
                                      @RequestParam(required = false, name = "hospital") Long hospitalId) {

        return hospitalWardService
                .findAll(
                        HospitalWardParams
                                .builder()
                                .wardType(wardType)
                                .minCapacity(minCapacity)
                                .maxCapacity(maxCapacity)
                                .hospitalId(hospitalId)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalWard> findOne(@PathVariable Long id) {
        return hospitalWardService.findOne(id);
    }

    @GetMapping("/{id}/reviews")
    public List<HospitalReview> findHospitalReviews(@PathVariable Long id) {
        return hospitalWardService
                .findOne(id)
                .map(HospitalWard::getHospitalReviews)
                .orElse(new ArrayList<>());
    }

    @GetMapping("/{id}/stays")
    public List<HospitalStay> findHospitalStays(@PathVariable Long id) {
        return hospitalWardService
                .findOne(id)
                .map(HospitalWard::getHospitalStays)
                .orElse(new ArrayList<>());
    }

    @PostMapping
    public void createHospitalWard(@RequestBody HospitalWard hospitalWard) {
        hospitalService.findOne(hospitalWard.getHospital().getId())
                .ifPresentOrElse(
                        hospital -> {
                            hospitalWard.setHospital(hospital);
                            hospitalWardService.createOrUpdate(hospitalWard);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Hospital with given ID not found");
                        });
    }

    @PutMapping
    public void updateHospitalWard(@RequestBody HospitalWard hospitalWard) {
        hospitalWardService.createOrUpdate(hospitalWard);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalWard(@PathVariable Long id) {
        hospitalWardService.deleteById(id);
    }

}

package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;
import pl.mzlnk.emergencyspotapi.service.HospitalWardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wards")
@AllArgsConstructor
public class HospitalWardController {

    private final HospitalWardService hospitalWardService;

    @GetMapping
    public List<HospitalWard> findAll(@RequestParam(required = false, name = "ward") HospitalWardTypeEnum wardType,
                                      @RequestParam(required = false, name = "min_capacity") Integer minCapacity,
                                      @RequestParam(required = false, name = "max_capacity") Integer maxCapacity,
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

    @PostMapping
    public void createHospitalWard(@RequestBody HospitalWard hospitalWard) {
        hospitalWardService.createOrUpdate(hospitalWard);
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

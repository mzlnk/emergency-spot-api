package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.model.params.HospitalParams;
import pl.mzlnk.emergencyspotapi.service.HospitalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public List<Hospital> findAll(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Double longitude,
                                  @RequestParam(required = false) Double latitude,
                                  @RequestParam(required = false) String country,
                                  @RequestParam(required = false) String city,
                                  @RequestParam(required = false) List<HospitalWardTypeEnum> wards) {

        return hospitalService
                .findAll(
                        HospitalParams
                                .builder()
                                .name(name)
                                .longitude(longitude)
                                .latitude(latitude)
                                .country(country)
                                .city(city)
                                .wards(wards)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<Hospital> findById(@PathVariable long id) {
        return hospitalService.findOne(id);
    }

    @GetMapping("/nearest")
    public Optional<Hospital> findNearest(@RequestParam Double longitude,
                                          @RequestParam Double latitude) {
        return hospitalService.findNearest(longitude, latitude);
    }

    @PostMapping
    public void createHospital(@RequestBody Hospital hospital) {
        hospitalService.createOrUpdate(hospital);
    }

    @PutMapping
    public void updateHospital(@RequestBody Hospital hospital) {
        hospitalService.createOrUpdate(hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteById(id);
    }

}

package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.NewHospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalWardParams;
import pl.mzlnk.emergencyspotapi.service.HospitalReviewService;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;
import pl.mzlnk.emergencyspotapi.service.HospitalWardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wards")
@AllArgsConstructor
public class HospitalWardController {

    private final HospitalWardService hospitalWardService;
    private final HospitalReviewService hospitalReviewService;
    private final HospitalStayService hospitalStayService;

    @GetMapping
    public List<HospitalWardDto> findAll(@RequestParam(required = false, name = "ward") HospitalWardTypeEnum wardType,
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
    public Optional<HospitalWardDetailsDto> findOne(@PathVariable Long id) {
        return hospitalWardService.findOne(id);
    }

    @GetMapping("/{id}/reviews")
    public List<HospitalReviewDto> findHospitalReviews(@PathVariable Long id) {
        return hospitalReviewService
                .findAll(
                        HospitalReviewParams
                                .builder()
                                .hospitalId(id)
                                .build()
                );
    }

    @GetMapping("/{id}/stays")
    public List<HospitalStayDto> findHospitalStays(@PathVariable Long id) {
        return hospitalStayService
                .findAll(
                        HospitalStayParams
                                .builder()
                                .hospitalWardId(id)
                                .build()
                );
    }

    @PostMapping
    public void createHospitalWard(@RequestBody NewHospitalWardDto hospitalWard) {
        hospitalWardService.create(hospitalWard);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalWard(@PathVariable Long id) {
        hospitalWardService.deleteById(id);
    }

}

package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospital.HospitalDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalward.HospitalWardDto;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalWardTypeEnum;
import pl.mzlnk.emergencyspotapi.model.params.HospitalParams;
import pl.mzlnk.emergencyspotapi.service.HospitalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public List<HospitalDto> findAll(@RequestParam(required = false) String name,
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
                                .wards(wards != null ? wards : new ArrayList<>())
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalDetailsDto> findById(@PathVariable long id) {
        return hospitalService.findOne(id);
    }

    @GetMapping("/{id}/wards")
    public List<HospitalWardDto> findHospitalWards(@PathVariable long id) {
        return null;
        //        return hospitalService
//                .findOne(id)
//                .map(Hospital::getWards)
//                .orElse(new ArrayList<>());
    }

    @GetMapping("/nearest")
    public Optional<HospitalDetailsDto> findNearest(@RequestParam Double longitude,
                                          @RequestParam Double latitude) {
        return null;
        // return hospitalService.findNearest(longitude, latitude);
    }

}

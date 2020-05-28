package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.NewHospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.user.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;
import pl.mzlnk.emergencyspotapi.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stays")
@AllArgsConstructor
public class HospitalStayController {

    private final HospitalStayService hospitalStayService;
    private final UserService userService;

    @GetMapping
    public List<HospitalStayDto> findAll(@RequestParam(required = false, name = "date_from") @DateTimeFormat(pattern = "dd-MM-yyyy") Calendar dateFrom,
                                         @RequestParam(required = false, name = "date_to") @DateTimeFormat(pattern = "dd-MM-yyyy") Calendar dateTo,
                                         @RequestParam(required = false, name = "ward") Long hospitalWardId,
                                         @RequestParam(required = false, name = "patient") Long hospitalPatientId) {
        return hospitalStayService
                .findAll(
                        HospitalStayParams
                                .builder()
                                .dateFrom(dateFrom)
                                .dateTo(dateTo)
                                .hospitalWardId(hospitalWardId)
                                .hospitalPatientId(hospitalPatientId)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalStayDetailsDto> findById(@PathVariable Long id) {
        return hospitalStayService.findOne(id);
    }

    @GetMapping("/me")
    public List<HospitalStayDto> findUserHospitalStays(Principal principal) {
        return userService
                .findByUsername(principal.getName())
                .map(UserDto::getId)
                .map(id -> {
                    return hospitalStayService
                            .findAll(
                                    HospitalStayParams
                                            .builder()
                                            .hospitalPatientId(id)
                                            .build()
                            );
                })
                .orElse(new ArrayList<>());
    }

    @PostMapping
    public void createHospitalStay(@RequestBody NewHospitalStayDto hospitalStay) {
        hospitalStayService.create(hospitalStay);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalStay(@PathVariable Long id) {
        hospitalStayService.deleteById(id);
    }

}

package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.NewHospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stays")
@AllArgsConstructor
public class HospitalStayController {

    private final HospitalStayService hospitalStayService;

    @GetMapping
    public List<HospitalStayDto> findAll(@RequestParam(required = false, name = "date_from") @DateTimeFormat(pattern = "dd-MM-yyyy") Calendar dateFrom,
                                         @RequestParam(required = false, name = "date_to") @DateTimeFormat(pattern = "dd-MM-yyyy") Calendar dateTo) {
        return hospitalStayService
                .findAll(
                        HospitalStayParams
                                .builder()
                                .dateFrom(dateFrom)
                                .dateTo(dateTo)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalStayDetailsDto> findById(@PathVariable Long id) {
        return hospitalStayService.findOne(id);
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

package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stays")
@AllArgsConstructor
public class HospitalStayController {

    private final HospitalStayService hospitalStayService;

    @GetMapping
    public List<HospitalStay> findAll(@RequestParam(required = false, name = "date_from") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateFrom,
                                      @RequestParam(required = false, name = "date_to") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateTo) {
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
    public Optional<HospitalStay> findById(@PathVariable Long id) {
        return hospitalStayService.findOne(id);
    }

    @PostMapping
    public void createHospitalStay(@RequestBody HospitalStay hospitalStay) {
        hospitalStayService.createOrUpdate(hospitalStay);
    }

    @PutMapping
    public void updateHospitalStay(@RequestBody HospitalStay hospitalStay) {
        hospitalStayService.createOrUpdate(hospitalStay);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalStay(@PathVariable Long id) {
        hospitalStayService.deleteById(id);
    }

}
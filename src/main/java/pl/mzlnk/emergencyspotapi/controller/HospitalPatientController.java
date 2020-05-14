package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.HospitalPatient;
import pl.mzlnk.emergencyspotapi.model.params.HospitalPatientParams;
import pl.mzlnk.emergencyspotapi.service.HospitalPatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class HospitalPatientController {

    private final HospitalPatientService hospitalPatientService;

    @GetMapping
    public List<HospitalPatient> findAll(@RequestParam(required = false, name = "first_name") String firstName,
                                         @RequestParam(required = false, name = "last_name") String lastName) {
        return hospitalPatientService
                .findAll(
                        HospitalPatientParams
                                .builder()
                                .firstName(firstName)
                                .lastName(lastName)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalPatient> findById(@PathVariable Long id) {
        return hospitalPatientService.findOne(id);
    }

    @PostMapping
    public void createHospital(@RequestBody HospitalPatient hospitalPatient) {
        hospitalPatientService.createOrUpdate(hospitalPatient);
    }

    @PutMapping
    public void updateHospital(@RequestBody HospitalPatient hospitalPatient) {
        hospitalPatientService.createOrUpdate(hospitalPatient);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalPatientService.deleteById(id);
    }

}

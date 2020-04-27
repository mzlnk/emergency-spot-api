package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.service.HospitalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/")
    public List<Hospital> findAll() {
        return hospitalService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hospital> findById(@PathVariable long id) {
        return ExampleMatcher.matchingAll().
    }

    @

}

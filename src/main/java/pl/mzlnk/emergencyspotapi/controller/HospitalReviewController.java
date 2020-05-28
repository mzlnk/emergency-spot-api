package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.NewHospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.UpdateHospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;
import pl.mzlnk.emergencyspotapi.service.HospitalReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class HospitalReviewController {

    private final HospitalReviewService hospitalReviewService;

    @GetMapping
    public List<HospitalReviewDto> findAll(@RequestParam(required = false, name = "min_rating") Double minRating,
                                           @RequestParam(required = false, name = "max_rating") Double maxRating,
                                           @RequestParam(required = false, name = "hospital") Long hospitalId) {

        return hospitalReviewService
                .findAll(
                        HospitalReviewParams
                                .builder()
                                .minRating(minRating)
                                .maxRating(maxRating)
                                .hospitalId(hospitalId)
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Optional<HospitalReviewDetailsDto> findOne(@PathVariable Long id) {
        return hospitalReviewService.findOne(id);
    }

    @PostMapping
    public HospitalReviewDetailsDto createReview(@RequestBody NewHospitalReviewDto review) {
        return hospitalReviewService.create(review);
    }

    @PutMapping
    public HospitalReviewDetailsDto updateReview(@RequestBody UpdateHospitalReviewDto review) {
        return hospitalReviewService.update(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        hospitalReviewService.deleteById(id);
    }

}

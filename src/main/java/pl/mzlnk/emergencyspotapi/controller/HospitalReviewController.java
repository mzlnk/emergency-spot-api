package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public List<HospitalReview> findAll(@RequestParam(required = false, name = "min_rating") Double minRating,
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
    public Optional<HospitalReview> findOne(@PathVariable Long id) {
        return hospitalReviewService.findOne(id);
    }

    @PostMapping
    public void createReview(@RequestBody HospitalReview review) {
        hospitalReviewService.createOrUpdate(review);
    }

    @PutMapping
    public void updateReview(@RequestBody HospitalReview review) {
        hospitalReviewService.createOrUpdate(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        hospitalReviewService.deleteById(id);
    }

}

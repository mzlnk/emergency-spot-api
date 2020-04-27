package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalRepository;
import pl.mzlnk.emergencyspotapi.repository.HospitalReviewRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalReviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalReviewServiceImpl implements HospitalReviewService {

    private final HospitalReviewRepository hospitalReviewRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public List<HospitalReview> findAll(HospitalReviewParams params) {
        List<HospitalReview> result = hospitalReviewRepository.findAll(params.toExample());

        result = result
                .stream()
                .filter(review -> review.getRating() > params.minRating)
                .filter(review -> review.getRating() < params.maxRating)
                .collect(Collectors.toList());

        final List<HospitalReview> finalResult = result;
        result = Optional.of(params.hospitalId)
                .flatMap(hospitalRepository::findById)
                .map(hospital -> {
                    return finalResult
                            .stream()
                            .filter(review -> review.getHospital().equals(hospital))
                            .collect(Collectors.toList());
                })
                .orElse(finalResult);

        return result;
    }

    @Override
    public Optional<HospitalReview> findOne(Long id) {
        return hospitalReviewRepository.findById(id);
    }

    @Override
    public void createOrUpdate(HospitalReview hospitalReview) {
        hospitalReviewRepository.save(hospitalReview);
    }

    @Override
    public void delete(HospitalReview hospitalReview) {
        hospitalReviewRepository.delete(hospitalReview);
    }

    @Override
    public void deleteById(long id) {
        hospitalReviewRepository.deleteById(id);
    }

}

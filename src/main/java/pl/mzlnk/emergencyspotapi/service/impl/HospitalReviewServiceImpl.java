package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalReviewRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalReviewService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalReviewServiceImpl implements HospitalReviewService {

    private final HospitalReviewRepository hospitalReviewRepository;

    @Override
    public List<HospitalReview> findAll(EntityParams<HospitalReview> params) {
        return hospitalReviewRepository
                .findAll(params.toExample())
                .stream()
                .filter(review -> review.getRating() > ((HospitalReviewParams) params).minRating)
                .filter(review -> review.getRating() < ((HospitalReviewParams) params).maxRating)
                .collect(Collectors.toList());
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
    public void deleteById(Long id) {
        hospitalReviewRepository.deleteById(id);
    }

}

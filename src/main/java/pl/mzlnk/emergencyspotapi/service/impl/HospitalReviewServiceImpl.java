package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.HospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.NewHospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalreview.UpdateHospitalReviewDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalReview;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalReviewParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalReviewRepository;
import pl.mzlnk.emergencyspotapi.repository.HospitalStayRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalReviewService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalReviewServiceImpl implements HospitalReviewService {

    private final HospitalReviewRepository hospitalReviewRepository;
    private final HospitalStayRepository hospitalStayRepository;

    @Override
    public List<HospitalReviewDto> findAll(EntityParams<HospitalReview> params) {
        return hospitalReviewRepository
                .findAll(params.toExample())
                .stream()
                .filter(review -> review.getRating() > ((HospitalReviewParams) params).minRating)
                .filter(review -> review.getRating() < ((HospitalReviewParams) params).maxRating)
                .map(HospitalReviewDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HospitalReviewDetailsDto> findOne(Long id) {
        return hospitalReviewRepository.findById(id)
                .map(HospitalReviewDetailsDto::fromEntity);
    }

    @Override
    public HospitalReviewDetailsDto create(NewHospitalReviewDto dto) {
        return hospitalStayRepository
                .findById(dto.getHospitalStayId())
                .map(hospitalStay -> {
                            HospitalReview hospitalReview = HospitalReview.builder()
                                    .hospitalStay(hospitalStay)
                                    .hospitalWard(hospitalStay.getHospitalWard())
                                    .rating(dto.getRating())
                                    .build();

                            return hospitalReviewRepository.save(hospitalReview);
                        }
                )
                .map(HospitalReviewDetailsDto::fromEntity)
                .orElseThrow(EntityExistsException::new);
    }

    @Override
    public HospitalReviewDetailsDto update(UpdateHospitalReviewDto dto) {
        return hospitalReviewRepository
                .findById(dto.getHospitalReviewId())
                .map(hospitalReview -> {
                            hospitalReview.setRating(dto.getNewRating());
                            return hospitalReviewRepository.save(hospitalReview);
                        }
                )
                .map(HospitalReviewDetailsDto::fromEntity)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        hospitalReviewRepository.deleteById(id);
    }

}

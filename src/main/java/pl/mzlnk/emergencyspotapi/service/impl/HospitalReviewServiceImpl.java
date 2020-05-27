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
    public void create(NewHospitalReviewDto dto) {
        hospitalStayRepository.findById(dto.getHospitalStayId())
                .ifPresentOrElse(hospitalStay -> {
                            HospitalReview hospitalReview = HospitalReview.builder()
                                    .hospitalStay(hospitalStay)
                                    .hospitalWard(hospitalStay.getHospitalWard())
                                    .rating(dto.getRating())
                                    .build();

                            hospitalReviewRepository.save(hospitalReview);
                        },
                        () -> {
                            throw new EntityNotFoundException();
                        }
                );
    }

    @Override
    public void update(UpdateHospitalReviewDto dto) {
        hospitalReviewRepository.findById(dto.getHospitalReviewId())
                .ifPresentOrElse(
                        hospitalReview -> {
                            hospitalReview.setRating(dto.getNewRating());
                            hospitalReviewRepository.save(hospitalReview);
                        },
                        () -> {
                            throw new EntityNotFoundException();
                        }
                );
    }

    @Override
    public void deleteById(Long id) {
        hospitalReviewRepository.deleteById(id);
    }

}

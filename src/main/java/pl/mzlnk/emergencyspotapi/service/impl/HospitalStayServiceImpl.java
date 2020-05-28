package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDetailsDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.HospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.dto.hospitalstay.NewHospitalStayDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;
import pl.mzlnk.emergencyspotapi.model.params.EntityParams;
import pl.mzlnk.emergencyspotapi.model.params.HospitalStayParams;
import pl.mzlnk.emergencyspotapi.repository.HospitalPatientRepository;
import pl.mzlnk.emergencyspotapi.repository.HospitalStayRepository;
import pl.mzlnk.emergencyspotapi.repository.HospitalWardRepository;
import pl.mzlnk.emergencyspotapi.service.HospitalStayService;
import pl.mzlnk.emergencyspotapi.utils.distance.BiOptional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalStayServiceImpl implements HospitalStayService {

    private final HospitalStayRepository hospitalStayRepository;
    private final HospitalWardRepository hospitalWardRepository;
    private final HospitalPatientRepository hospitalPatientRepository;

    @Override
    public List<HospitalStayDto> findAll(EntityParams<HospitalStay> params) {
        HospitalStayParams hospitalStayParams = (HospitalStayParams) params;

        return hospitalStayRepository.findHospitalStaysByDateFromAfterAndDateToBefore(hospitalStayParams.dateFrom, hospitalStayParams.dateTo)
                .stream()
                .map(HospitalStayDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HospitalStayDetailsDto> findOne(Long id) {
        return hospitalStayRepository.findById(id)
                .map(HospitalStayDetailsDto::fromEntity);
    }

    @Override
    public HospitalStayDetailsDto create(NewHospitalStayDto dto) {
        return BiOptional.of(
                hospitalWardRepository.findById(dto.getHospitalWardId()),
                hospitalPatientRepository.findById(dto.getPatientId())
        )
                .map((hospitalWard, hospitalPatient) -> {
                            HospitalStay hospitalStay = HospitalStay.builder()
                                    .hospitalPatient(hospitalPatient)
                                    .hospitalWard(hospitalWard)
                                    .dateFrom(dto.getDateFrom())
                                    .dateTo(dto.getDateTo())
                                    .build();

                            return hospitalStayRepository.save(hospitalStay);
                        }
                )
                .map(HospitalStayDetailsDto::fromEntity)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        hospitalStayRepository.deleteById(id);
    }

}

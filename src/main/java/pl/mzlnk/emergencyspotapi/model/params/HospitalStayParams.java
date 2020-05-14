package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.HospitalStay;

import java.time.LocalDate;

@Builder
public class HospitalStayParams implements EntityParams<HospitalStay> {

    @Builder.Default
    public final LocalDate dateFrom = LocalDate.of(1980, 1, 1);

    @Builder.Default
    public final LocalDate dateTo = LocalDate.of(2100, 1, 1);

    @Override
    public Example<HospitalStay> toExample() {
        return Example.of(
                HospitalStay
                        .builder()
                        .build()
        );
    }

}

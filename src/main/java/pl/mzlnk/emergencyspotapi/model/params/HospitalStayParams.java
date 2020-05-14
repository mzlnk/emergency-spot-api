package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalStay;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Builder
public class HospitalStayParams implements EntityParams<HospitalStay> {

    @Builder.Default
    public final Calendar dateFrom = new GregorianCalendar(1980, Calendar.JANUARY, 1);

    @Builder.Default
    public final Calendar dateTo = new GregorianCalendar(2100, Calendar.JANUARY, 1);

    @Override
    public Example<HospitalStay> toExample() {
        return Example.of(
                HospitalStay
                        .builder()
                        .build()
        );
    }

}

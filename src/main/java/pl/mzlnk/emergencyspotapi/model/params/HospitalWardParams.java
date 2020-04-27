package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;

@Builder
public class HospitalWardParams {

    public final HospitalWardTypeEnum wardType;
    public final Integer minCapacity = 0;
    public final Integer maxCapacity = Integer.MAX_VALUE;
    public final Long hospitalId;

    public final Example<HospitalWard> toExample() {
        return Example.of(
                HospitalWard
                .builder()
                .wardType(this.wardType)
                .build()
        );
    }

}

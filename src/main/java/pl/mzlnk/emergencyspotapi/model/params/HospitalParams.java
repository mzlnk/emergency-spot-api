package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import lombok.Singular;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.Hospital;
import pl.mzlnk.emergencyspotapi.model.HospitalWardTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Builder
public class HospitalParams {

    public final String name;
    public final Double longitude;
    public final Double latitude;
    public final String country;
    public final String city;

    @Singular
    public final List<HospitalWardTypeEnum> wards = new ArrayList<>();

    public final Example<Hospital> toExample() {
        return Example.of(
                Hospital
                        .builder()
                        .name(this.name)
                        .longitude(this.longitude)
                        .latitude(this.latitude)
                        .country(this.country)
                        .city(this.city)
                        .build()
        );
    }

}

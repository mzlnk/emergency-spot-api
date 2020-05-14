package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.HospitalPatient;

@Builder
public class HospitalPatientParams implements EntityParams<HospitalPatient> {

    public final String firstName;
    public final String lastName;

    @Override
    public Example<HospitalPatient> toExample() {
        return Example.of(
                HospitalPatient
                        .builder()
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .build()
        );
    }

}

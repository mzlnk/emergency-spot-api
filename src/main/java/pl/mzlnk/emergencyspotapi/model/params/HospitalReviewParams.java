package pl.mzlnk.emergencyspotapi.model.params;

import lombok.Builder;
import org.springframework.data.domain.Example;
import pl.mzlnk.emergencyspotapi.model.HospitalReview;

@Builder
public class HospitalReviewParams {

    @Builder.Default
    public final Double minRating = 0D;

    @Builder.Default
    public final Double maxRating = 10D;

    public final Long hospitalId;

    public final Example<HospitalReview> toExample() {
        return Example.of(
                HospitalReview
                        .builder()
                        .hospitalId(this.hospitalId)
                        .build()
        );
    }

}

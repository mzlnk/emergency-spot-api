package pl.mzlnk.emergencyspotapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "hospital_reviews")
@AttributeOverride(name = "id", column = @Column(name = "hospital_review_id"))
public class HospitalReview extends IdentifiableEntity {

    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "hospital_ward_id", referencedColumnName = "hospital_ward_id")
    private HospitalWard hospitalWard;

    @OneToOne
    @JoinColumn(name = "hospital_stay_id", referencedColumnName = "hospital_stay_id")
    private HospitalStay hospitalStay;

    public HospitalReview() {
        super();
    }

}

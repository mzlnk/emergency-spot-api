package pl.mzlnk.emergencyspotapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "hospital_wards")
@AttributeOverride(name = "id", column = @Column(name = "hospital_ward_id"))
public class HospitalWard extends IdentifiableEntity {

    @Column(name = "ward_type")
    @Enumerated(EnumType.STRING)
    private HospitalWardTypeEnum wardType;

    @Column(name = "capacity")
    private Long capacity;

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "hospitalWard")
    private List<HospitalReview> hospitalReviews;

    @OneToMany(mappedBy = "hospitalWard")
    private List<HospitalStay> hospitalStays;

    public HospitalWard() {
        super();
    }

}

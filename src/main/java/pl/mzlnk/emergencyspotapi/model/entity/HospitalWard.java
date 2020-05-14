package pl.mzlnk.emergencyspotapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
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
    @JsonBackReference
    private Hospital hospital;

    @OneToMany(mappedBy = "hospitalWard")
    @JsonBackReference
    private List<HospitalReview> hospitalReviews;

    @OneToMany(mappedBy = "hospitalWard")
    @JsonBackReference
    private List<HospitalStay> hospitalStays;

    public HospitalWard() {
        super();
    }

}

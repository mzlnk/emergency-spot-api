package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
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
    @JsonIgnoreProperties({"wards"})
    private Hospital hospital;

    @OneToMany(mappedBy = "hospitalWard")
    @JsonIgnoreProperties({"hospitalWard"})
    private List<HospitalReview> hospitalReviews;

    @OneToMany(mappedBy = "hospitalWard")
    @JsonIgnoreProperties({"hospitalWard"})
    private List<HospitalStay> hospitalStays;

    public HospitalWard() {
        super();
    }

}

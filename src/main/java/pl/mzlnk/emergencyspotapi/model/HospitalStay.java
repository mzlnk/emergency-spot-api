package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Entity
@SuperBuilder
@AllArgsConstructor
@Table(name = "hospital_stays")
@AttributeOverride(name = "id", column = @Column(name = "hospital_stay_id"))
public class HospitalStay extends IdentifiableEntity {

    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Calendar dateFrom;

    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Calendar dateTo;

    @OneToOne(mappedBy = "hospitalStay")
    @JsonIgnoreProperties({"hospitalStay"})
    private HospitalReview hospitalReview;

    @ManyToOne
    @JoinColumn(name = "hospital_patient_id", referencedColumnName = "hospital_patient_id")
    @JsonIgnoreProperties({"hospitalStays"})
    private HospitalPatient hospitalPatient;

    @ManyToOne
    @JoinColumn(name = "hospital_ward_id", referencedColumnName = "hospital_ward_id")
    @JsonIgnoreProperties({"hospitalStays"})
    private HospitalWard hospitalWard;

    public HospitalStay() {
        super();
    }

}

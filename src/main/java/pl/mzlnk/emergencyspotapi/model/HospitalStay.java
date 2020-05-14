package pl.mzlnk.emergencyspotapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
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
    private HospitalReview hospitalReview;

    @ManyToOne
    @JoinColumn(name = "hospital_patient_id", referencedColumnName = "hospital_patient_id")
    private HospitalPatient hospitalPatient;

    @ManyToOne
    @JoinColumn(name = "hospital_ward_id", referencedColumnName = "hospital_ward_id")
    private HospitalWard hospitalWard;

    public HospitalStay() {
        super();
    }

}

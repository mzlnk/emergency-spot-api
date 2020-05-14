package pl.mzlnk.emergencyspotapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name = "hospital_patients")
@AttributeOverride(name = "id", column = @Column(name = "hospital_patient_id"))
public class HospitalPatient extends IdentifiableEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "hospitalPatient")
    private List<HospitalStay> hospitalStays;

    public HospitalPatient() {
        super();
    }

}

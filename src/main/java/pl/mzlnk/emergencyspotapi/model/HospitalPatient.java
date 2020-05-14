package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@SuperBuilder
@AllArgsConstructor
@Table(name = "hospital_patients")
@AttributeOverride(name = "id", column = @Column(name = "hospital_patient_id"))
public class HospitalPatient extends IdentifiableEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "hospitalPatient")
    @JsonBackReference
    private List<HospitalStay> hospitalStays;

    public HospitalPatient() {
        super();
    }

}

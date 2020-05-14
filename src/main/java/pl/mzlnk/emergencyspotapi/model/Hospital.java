package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "hospital_id"))
@Table(name = "hospitals")
public class Hospital extends IdentifiableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "hospital")
    @JsonBackReference
    private List<HospitalWard> wards;

    public Hospital() {
        super();
    }

}

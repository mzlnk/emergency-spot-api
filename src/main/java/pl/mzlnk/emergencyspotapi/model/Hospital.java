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
    private List<HospitalWard> wards;

    public Hospital() {
        super();
    }

}

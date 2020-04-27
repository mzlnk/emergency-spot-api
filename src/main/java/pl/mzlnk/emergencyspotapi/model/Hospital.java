package pl.mzlnk.emergencyspotapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name = "hospital_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private Integer streetNumber;

    @OneToMany(mappedBy = "hospital")
    private List<HospitalWard> wards;

    @OneToMany(mappedBy = "hospital")
    private List<HospitalReview> reviews;

}

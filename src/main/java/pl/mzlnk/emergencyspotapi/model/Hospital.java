package pl.mzlnk.emergencyspotapi.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name = "hospital_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private int streetNumber;

    @OneToMany(mappedBy = "hospital")
    private List<HospitalWard> wards;

    @OneToMany(mappedBy = "hospital")
    private List<HospitalReview> reviews;

}

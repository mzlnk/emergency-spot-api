package pl.mzlnk.emergencyspotapi.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "hospital_wards")
public class HospitalWard {

    @Id
    @GeneratedValue
    @Column(name = "hospital_ward_id")
    private long id;

    @Column(name = "ward_type")
    @Enumerated(EnumType.STRING)
    private HospitalWardTypeEnum wardType;

    @Column(name = "capacity")
    private long capacity;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}

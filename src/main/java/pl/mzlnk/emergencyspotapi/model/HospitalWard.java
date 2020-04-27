package pl.mzlnk.emergencyspotapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
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

package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_wards")
public class HospitalWard {

    @Id
    @GeneratedValue
    @Column(name = "hospital_ward_id")
    private Long id;

    @Column(name = "ward_type")
    @Enumerated(EnumType.STRING)
    private HospitalWardTypeEnum wardType;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "hospital_id")
    private Long hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospital_id", insertable = false, updatable = false)
    @JsonBackReference
    private Hospital hospital;

}

package pl.mzlnk.emergencyspotapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_reviews")
public class HospitalReview {

    @Id
    @GeneratedValue
    @Column(name = "hospital_review_id")
    private Long id;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "hospital_id")
    private Long hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospital_id", insertable = false, updatable = false)
    @JsonBackReference
    private Hospital hospital;

}

package pl.mzlnk.emergencyspotapi.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
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

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}

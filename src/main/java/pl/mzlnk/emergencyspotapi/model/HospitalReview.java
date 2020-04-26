package pl.mzlnk.emergencyspotapi.model;

import javax.persistence.*;

@Entity
@Table(name = "hospital_reviews")
public class HospitalReview {

    @Id
    @GeneratedValue
    @Column(name = "hospital_review_id")
    private long id;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}

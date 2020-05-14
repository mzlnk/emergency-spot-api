package pl.mzlnk.emergencyspotapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdentifiableEntity {

    @Id
    @GeneratedValue
    private Long id;

    public IdentifiableEntity() {

    }

}

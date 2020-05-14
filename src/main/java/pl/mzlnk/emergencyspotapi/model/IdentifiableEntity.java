package pl.mzlnk.emergencyspotapi.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@SuperBuilder
@MappedSuperclass
public class IdentifiableEntity {

    @Id
    @GeneratedValue
    private Long id;

    public IdentifiableEntity() {

    }

}

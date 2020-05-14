package pl.mzlnk.emergencyspotapi.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class IdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public IdentifiableEntity() {

    }

}

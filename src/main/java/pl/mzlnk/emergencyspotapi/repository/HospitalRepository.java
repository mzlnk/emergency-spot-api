package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.Hospital;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

    List<Hospital> findAll(Example<Hospital> example);

}

package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalWard;

import java.util.List;

@Repository
public interface HospitalWardRepository extends CrudRepository<HospitalWard, Long> {

    List<HospitalWard> findAll(Example<HospitalWard> example);

}

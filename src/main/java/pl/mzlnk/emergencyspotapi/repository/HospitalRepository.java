package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.Hospital;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

    List<Hospital> findByCountry(String country);
    List<Hospital> findByCity(String city);

    Optional<Hospital> findByName(String name);
    Optional<Hospital> findByLongitudeAndLatitude(double longitude, double latitude);

}

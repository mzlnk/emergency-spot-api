package pl.mzlnk.emergencyspotapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzlnk.emergencyspotapi.model.HospitalStay;

import java.util.Calendar;
import java.util.List;

@Repository
public interface HospitalStayRepository extends JpaRepository<HospitalStay, Long> {

    List<HospitalStay> findHospitalStaysByDateFromAfterAndDateToBefore(Calendar dateFrom, Calendar dateTo);

}

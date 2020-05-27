package pl.mzlnk.emergencyspotapi.model.dto.hospitalstay;

import lombok.Data;

import java.util.Calendar;

@Data
public class NewHospitalStayDto {

    private Long hospitalWardId;
    private Long patientId;

    private Calendar dateFrom;
    private Calendar dateTo;

}

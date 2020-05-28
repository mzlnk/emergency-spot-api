package pl.mzlnk.emergencyspotapi.model.dto.hospitalstay;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Calendar;

@Data
public class NewHospitalStayDto {

    private Long hospitalWardId;
    private Long patientId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Calendar dateFrom;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Calendar dateTo;

}

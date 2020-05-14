package pl.mzlnk.emergencyspotapi.utils.distance;

import lombok.AllArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.entity.Hospital;

@AllArgsConstructor
public final class Coordinates {

    private final double longitude;
    private final double latitude;

    public static Coordinates fromHospital(Hospital hospital) {
        return new Coordinates(hospital.getLongitude(), hospital.getLatitude());
    }

    public double longitude() {
        return longitude;
    }

    public double latitude() {
        return latitude;
    }

}

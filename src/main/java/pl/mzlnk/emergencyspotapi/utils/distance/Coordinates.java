package pl.mzlnk.emergencyspotapi.utils.distance;

import pl.mzlnk.emergencyspotapi.model.Hospital;

public record Coordinates(double longitude, double latitude) {

    public static Coordinates fromHospital(Hospital hospital) {
        return new Coordinates(hospital.getLongitude(), hospital.getLatitude());
    }

}

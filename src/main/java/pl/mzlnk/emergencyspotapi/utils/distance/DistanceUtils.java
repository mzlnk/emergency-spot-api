package pl.mzlnk.emergencyspotapi.utils.distance;

import static java.lang.Math.*;

public class DistanceUtils {

    private static final double R = 6371D;

    public double calculateDistance(Coordinates c1, Coordinates c2) {
        double dLatitude = Math.abs(c1.latitude() - c2.latitude());
        double dLongitude = Math.abs(c1.longitude() - c2.longitude());

        double a = pow(sin(dLatitude / 2), 2)
                + cos(c1.latitude())
                * cos(c2.latitude())
                * pow(sin(dLongitude / 2), 2);

        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return R * c;
    }

}

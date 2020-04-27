package pl.mzlnk.emergencyspotapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mzlnk.emergencyspotapi.utils.distance.DistanceUtils;

@Configuration
public class DistanceUtilsConfig {

    @Bean
    public DistanceUtils distanceUtils() {
        return new DistanceUtils();
    }

}

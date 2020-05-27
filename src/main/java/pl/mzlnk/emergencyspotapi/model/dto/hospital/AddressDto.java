package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mzlnk.emergencyspotapi.model.entity.Address;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDto {

    public static AddressDto fromEntity(Address address) {
        AddressDto dto = new AddressDto();

        dto.country = address.getCountry();
        dto.city = address.getCity();
        dto.street = address.getStreet();
        dto.streetNumber = address.getStreetNumber();

        return dto;
    }

    private String country;
    private String city;
    private String street;
    private Long streetNumber;

}

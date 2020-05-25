package pl.mzlnk.emergencyspotapi.model.dto.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.mzlnk.emergencyspotapi.model.entity.Address;

@Data
@AllArgsConstructor
public class AddressDto {

    private String country;
    private String city;
    private String street;
    private Long streetNumber;

    public AddressDto(Address address) {
        this.country = address.getCountry();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
    }

}

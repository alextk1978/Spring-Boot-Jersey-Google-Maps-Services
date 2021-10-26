package geocoding.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObject {

    @JsonProperty("place_id")
    String placeId;

    @JsonProperty("address_components")
    List<AddressComponent> addressComponents;

    @JsonProperty("formatted_address")
    String formattedAddress;
}

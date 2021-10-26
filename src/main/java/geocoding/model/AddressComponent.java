package geocoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddressComponent {

    @JsonProperty("long_name")
    String longName;

    @JsonProperty("short_name")
    String shortName;

    List<String> types;
}

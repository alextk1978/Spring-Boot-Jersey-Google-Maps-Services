package ru.alextk.test_google_map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexey Tkachenko
 */

@Data
public class AddressComponent implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("long_name")
    private String longName;

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("types")
    private List<String> types;
}

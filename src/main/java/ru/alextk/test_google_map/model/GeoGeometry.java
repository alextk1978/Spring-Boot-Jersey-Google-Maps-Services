package ru.alextk.test_google_map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Alexey Tkachenko
 */

@Data
public class GeoGeometry implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("location")
    private GeoLocation geoLocation;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("viewport")
    private GeoViewPort viewPort;

    @JsonProperty("bounds")
    private Bounds bounds;
}

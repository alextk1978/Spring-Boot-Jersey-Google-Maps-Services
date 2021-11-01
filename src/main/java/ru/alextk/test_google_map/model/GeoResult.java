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
public class GeoResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("results")
    private List<GeoObject> results;

    @JsonProperty("status")
    private String status;

    @JsonProperty("plus_code")
    private GeoPlusCode plusCode;
}

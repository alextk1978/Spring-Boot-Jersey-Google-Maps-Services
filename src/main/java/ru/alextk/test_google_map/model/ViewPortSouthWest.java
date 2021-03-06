package ru.alextk.test_google_map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Alexey Tkachenko
 */

@Data
public class ViewPortSouthWest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;
}

package ru.alextk.test_google_map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Alexey Tkachenko
 */

@Data
public class Bounds implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("southwest")
    private ViewPortSouthWest viewPortSouthWest;

    @JsonProperty("northeast")
    private ViewPortNorthEast viewPortNorthEast;
}

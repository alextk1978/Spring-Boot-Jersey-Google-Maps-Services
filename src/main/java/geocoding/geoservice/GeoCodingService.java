package geocoding.geoservice;

import geocoding.model.Geo;

import java.io.UnsupportedEncodingException;

public interface GeoCodingService {
    Geo getGeocode(String address) throws UnsupportedEncodingException;
}

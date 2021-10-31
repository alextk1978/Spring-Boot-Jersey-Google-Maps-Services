package ru.alextk.test_google_map.service;

import ru.alextk.test_google_map.model.GeoResult;

/**
 * @author Alexey Tkachenko
 */

public interface GeoService {
    GeoResult getGeocode (String address);
    GeoResult getAddress (String code);

}

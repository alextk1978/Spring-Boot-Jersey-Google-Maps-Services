package ru.alextk.test_google_map.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alextk.test_google_map.model.GeoResult;
import ru.alextk.test_google_map.service.GeoService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Alexey Tkachenko
 */

@Slf4j
@Component
@Path("/api")
public class GoogleMapApi {

    private final GeoService geoService;

    @Autowired
    private GoogleMapApi(GeoService geoService) {
        this.geoService = geoService;
    }

    @GET
    @Path("/code/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public GeoResult getGeoCode(@PathParam("address") String address) {
        return geoService.getGeocode(address);
    }

    @GET
    @Path("/decode/{geo}")
    @Produces(MediaType.APPLICATION_JSON)
    public GeoResult getAddress(@PathParam("geo") String geo) {
        return geoService.getAddress(geo);
    }
}
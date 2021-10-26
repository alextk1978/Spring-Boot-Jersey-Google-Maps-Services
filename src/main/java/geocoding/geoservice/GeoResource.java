package geocoding.geoservice;

import geocoding.model.Geo;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
@Path("/api/v1/geo")
public class GeoResource {
    private static final String GOOGLE_MAP_GEOCODING_API_URL
            = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private static final String API_KEY = "AIzaSyAHQIILvWIWOguqyXX9nCexRuHNz2y-gO8";

    @GET
    @Path("/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGeocode(@PathParam("address") String address) throws UnsupportedEncodingException {

        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
        String url = GOOGLE_MAP_GEOCODING_API_URL + encodedAddress + API_KEY;

        Client client = ClientBuilder.newClient();
        String st = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        return st;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/a")
    public String getString() {
        return "OK!";
    }
}

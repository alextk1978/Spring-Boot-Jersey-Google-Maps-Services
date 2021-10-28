package geocoding.geoservice;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;



@Component
@Path("/")
public class GeoResource {
    private static final String GOOGLE_MAP_GEOCODING_API_URL
            = "https://maps.googleapis.com/maps/api/geocode/json";
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
        return "index";
    }
//
//    @RequestMapping(path = "/geocode", method = RequestMethod.GET )
//    public GeocodeResult getGeocode(@RequestParam String address) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        String encodedAddress = URLEncoder.encode(address, "UTF-8");
//        Request request = new Request.Builder()
//                .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress)
//                .get()
//                .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", {your-api-key-here}/*  Use your API Key here */)
//                .build();
//        ResponseBody responseBody = client.newCall(request).execute().body();
//        ObjectMapper objectMapper = new ObjectMapper();
//        GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
//        return result;
//    }
}

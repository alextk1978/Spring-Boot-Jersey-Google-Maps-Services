package geocoding.config;

import geocoding.geoservice.GeoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GeoResource.class);
    }
}
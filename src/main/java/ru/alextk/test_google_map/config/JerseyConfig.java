package ru.alextk.test_google_map.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import ru.alextk.test_google_map.service.GeoResource;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GeoResource.class);
    }
}

package bynull.poi.app;

import bynull.poi.rest.PoiResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PoiResource.class);
    }
}
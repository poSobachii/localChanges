package Micrometer;


import Micrometer.Controller.MainController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/path")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(MainController.class).
        register(MicrometerService.class);
    }
}
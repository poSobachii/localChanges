package JsonExample;


import JsonExample.Controller.PathController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/namepath")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PathController.class);
    }
}
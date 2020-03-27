package Micrometer.Controller;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@RestController
@Path("/yo")
public class MainController {

    @Context
    private HttpServletRequest httpServletRequest;

    @Context
    private HttpServletResponse HttpServletResponse;

    @Context
    private UriInfo uriInfo;

    @GET
    public String returnsmth() throws IOException {
        System.out.println("get worked");
        System.out.println(httpServletRequest.getQueryString());
        System.out.println(uriInfo.getAbsolutePath());
        HttpServletResponse.sendRedirect("yo/someRedirectPath?name=value");
        return "Hello get";
    }

    @GET
    @Path("/someRedirectPath")
    public String redirection(){
        System.out.println(httpServletRequest.getQueryString());
        System.out.println(uriInfo.getAbsolutePath());
        System.out.println("Redirection worked");
        return "Here is a redirect";
    }
}

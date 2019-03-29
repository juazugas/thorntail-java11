package com.example.java11.rest;

import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
        return Response.ok("Hello from Thorntail!")
                .build();
	}

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Response salute (@PathParam("name") String name) {
        var userName = Optional.ofNullable(name)
                .orElse("unknown");
        return Response.ok(String.format("Hello %s from Thorntail!", userName))
                .build();
    }
}

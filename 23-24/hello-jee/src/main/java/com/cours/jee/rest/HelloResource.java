package com.cours.jee.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloResource {
    @GET
    public void ping() {

    }

}

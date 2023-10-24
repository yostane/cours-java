package com.cours.jee.rest;

import com.cours.jee.model.Message;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/ping")
public class HelloResource {
    @GET
    public Message ping() {
        return new Message("Rest API is running");
    }

}

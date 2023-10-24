package com.cours.jee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.cours.jee.model.Message;

public class DemoApiIntegrationTest {
    String port = "8080";
    String url = "http://localhost:" + port + "/";

    @Test
    public void testPing() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url + "api/ping");
        Response response = target.request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                "Incorrect response code from " + url);

        Message json = response.readEntity(Message.class);

        assertEquals("Rest API is running", json.getValue());
        response.close();
        client.close();
    }
}

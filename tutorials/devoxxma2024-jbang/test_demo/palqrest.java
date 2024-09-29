/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
// Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:3.15.1}@pom
//DEPS io.quarkus:quarkus-resteasy
//DEPS io.quarkus:quarkus-resteasy-jsonb
//DEPS io.quarkus:quarkus-smallrye-openapi
//DEPS io.quarkus:quarkus-swagger-ui
//JAVAC_OPTIONS -parameters
//SOURCES PalindromeService.java
//Q:CONFIG quarkus.banner.enabled=false
//Q:CONFIG quarkus.swagger-ui.always-include=true

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Map;

record Result(String message) {
}

@Path("/palindrome")
@ApplicationScoped
public class palqrest {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> isPalidrome(@QueryParam("input") String input) {
        return Map.of("result",
                PalindromeService.isPalindrome(input) ? "Palindrome" : "Not Palindrome");
    }
}

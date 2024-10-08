///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
// Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:3.7.2}@pom
//DEPS io.quarkus:quarkus-resteasy
// //DEPS io.quarkus:quarkus-smallrye-openapi
// //DEPS io.quarkus:quarkus-swagger-ui
//JAVAC_OPTIONS -parameters

import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
@ApplicationScoped
public class helloqrest {

    @GET
    public String sayHello() {
        return "Hello from Quarkus with jbang.dev";
    }

}

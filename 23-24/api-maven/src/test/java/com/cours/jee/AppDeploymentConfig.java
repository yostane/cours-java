package com.cours.jee;
import org.microshed.testing.SharedContainerConfiguration;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;

public class AppDeploymentConfig implements SharedContainerConfiguration {

    @Container
    public static ApplicationContainer app = new ApplicationContainer()
                    .withAppContextRoot("/guide-microshed-testing")
                    .withReadinessPath("/health/ready");

}
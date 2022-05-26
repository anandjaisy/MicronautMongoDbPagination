package com.example;

import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Testcontainers
public abstract class TestContainerFixture implements TestPropertyProvider {
    protected static GenericContainer mongoDBContainer;
    static {
        mongoDBContainer = new GenericContainer(DockerImageName.parse("mongo:latest"))
                .withExposedPorts(27017)
                .withReuse(true);
        mongoDBContainer.start();
    }
    @Override
    public Map<String, String> getProperties() {

        return Map.of("mongodb.uri",
                String.format("mongodb://%s:%s/FeteBird-Product",
                        mongoDBContainer.getHost(),
                        mongoDBContainer.getMappedPort(27017)));
    }
}

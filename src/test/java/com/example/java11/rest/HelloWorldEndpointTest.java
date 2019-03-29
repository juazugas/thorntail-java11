package com.example.java11.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.Optional;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;
import io.restassured.RestAssured;


@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.WAR)
public class HelloWorldEndpointTest {


    @BeforeClass
    public static void setup () {
        RestAssured.port = Optional.ofNullable("server.port")
                .map(System::getProperty)
                .map(Integer::valueOf)
                .orElse(60888);
    }

    @Before
    public void setUp () throws Exception {
    }

    @Test
    @RunAsClient
    public void testDoGet () throws Exception {
        given().when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(equalTo("Hello from Thorntail!"));
    }

    @Test
    @RunAsClient
    public void testSalute () throws Exception {
        given().when()
                .get("/hello/USERNAME")
                .then()
                .statusCode(200)
                .body(equalTo("Hello USERNAME from Thorntail!"));
            
    }

}

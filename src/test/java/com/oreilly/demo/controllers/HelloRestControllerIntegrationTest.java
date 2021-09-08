package com.oreilly.demo.controllers;

import com.oreilly.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //This will autoconfigure several properties of the test, including making a TestRestTemplate available to inject.
public class HelloRestControllerIntegrationTest {

    @Autowired
    TestRestTemplate template;

    @Test
    /*
    * This test uses the getForEntity method of the template, which returns a ResponseEntity<Greeting>.
    * The response entity gives access to the headers, so the two provided asserts check the status code and the media type of the response.
    * The actual response is inside the body. By calling getBody, the response is returned as a de-serialized Greeting instance, which allows you to check its message.*/
    public void greetWithoutName(){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, World!", response.getMessage());

    }

    @Test
    /*
    * This test uses the getForObject method, which returns the de-serialized response directly.
    * This is simpler, but does not allow access to the headers.*/
    public void greetWithName(){
        Greeting response = template.getForObject("/rest?name=Sagar", Greeting.class);
        assertEquals("Hello, Sagar!", response.getMessage());
    }

}

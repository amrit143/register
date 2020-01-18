package com.poc.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RegisterApplicationTests {
	
	@LocalServerPort
    int randomServerPort;
	
	@Test
	@DisplayName("test hi message")
	void testHi() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/hi/";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		assertEquals("hi amrit!!", result.getBody());
		
	}
	
	@Test
	@Tag("JPA")
	@DisplayName("test push and get method")
    public void testAddEmployeeSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
        Employee employee = new Employee(1L, "Adam", 2, "python");
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
         
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }

}

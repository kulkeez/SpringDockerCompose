package com.kulkeez.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests. 
 * @RequestMapping maps / to the index() method. When invoked from a browser or using 
 * curl on the command line, the method returns pure text.
 * 
 * @author <a href="mailto:kulkeez@yahoo.com">Vikram Kulkarni</a> 
 *
 */
@RestController
@Slf4j
public class HelloController {

	@RequestMapping("/")
	/**
	 * 
	 * Here, we do not specify GET versus PUT, POST, and so forth. 
	 * By default @RequestMapping maps all HTTP operations. 
	 * You can use @GetMapping or @RequestMapping(method=GET) to narrow this mapping.
	 * 
	 * @return
	 */
	public Map<String, String> index() {
        log.debug("index() called.");
    	
    	// create mock/hard-coded JSON structure containing Greetings
    	HashMap<String, String> map = new HashMap<>();

	    map.put("Date", new Date().toString());
	    map.put("Message", "Greetings from Spring Data JPA Application using Postgres Database with Docker compose !");

        return map;
    }

	/** 
	 * 
	 * Mock an endpoint /connections
	 * 
	 * @return Returns the Response Header 'Location' having a randomAlphanumeric string of the form: Mbn8WfU7-iz9L-eKQ5-zPNR-wYDn6NBE3s32
	 */
	@GetMapping("/connections")
	public ResponseEntity<String> requestMicroServiceMetrics() {	
		String locationHeader = RandomStringUtils.randomAlphanumeric(8) + "-" + 
								RandomStringUtils.randomAlphanumeric(4) + "-" + 
								RandomStringUtils.randomAlphanumeric(4) + "-" + 
								RandomStringUtils.randomAlphanumeric(4) + "-" + 
								RandomStringUtils.randomAlphanumeric(12);
		log.debug("Location: {}", locationHeader);
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Location", locationHeader);

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Request for Metrics accepted, Location: " + locationHeader);
	}	
}

package com.kulkeez.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class SpringDataApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void autowiringWorked() {
		assertNotNull(context);
		log.info(context.getClass().getName());
	}
	
	@Test
	void contextLoads() {
		int count = context.getBeanDefinitionCount();
		log.info("There are " + count + " beans in the application context");
		
		String[] names = context.getBeanDefinitionNames();
		Arrays.stream(names)
				.sorted()
				.forEach(System.out::println);
	}
	
	
}

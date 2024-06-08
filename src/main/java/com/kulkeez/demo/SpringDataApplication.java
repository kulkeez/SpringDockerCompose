package com.kulkeez.demo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kulkeez.demo.model.Employee;
import com.kulkeez.demo.repository.EmployeeRepository;

/**
 * 
 * Entry program to launch this Spring Boot application. You can launch this application via command line 
 * by typing 'mvn spring-boot:run' from the project directory. 
 * 
 * Various Actuator RESTful end points are added to the application such as /env, /health, /info, 
 * /metrics, /trace and /dump that can be queried as listed below: 
 * 
 * http://localhost:8080/actuator/health
 * http://localhost:8080/actuator/info 
 * http://localhost:8080/actuator/mappings 
 * http://localhost:8080/actuator/env
 * http://localhost:8080/actuator/metrics 
 * 
 * @author <a href="mailto:kulkeez@yahoo.com">Vikram Kulkarni</a> 
 */
// convenience annotation that adds @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
@Slf4j
public class SpringDataApplication {

	/**
	 * Our main method delegates to Spring Boot’s SpringApplication class by calling run. 
	 * SpringApplication bootstraps our application, starting Spring, which, in turn, starts the 
	 * auto-configured Tomcat web server.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("Launching the Spring Docker Compose application ...");
		Timestamp tOne = new Timestamp(System.currentTimeMillis());
		
		// Launch the application
        SpringApplication.run(SpringDataApplication.class, args);
		//new SpringApplicationBuilder(SpringDataApplication.class).bannerMode(Mode.CONSOLE).run(args);
		log.info("Launched Spring Docker Compose application at time: {} ", tOne);
	}
      
	
	/**
	 * This method runs on start up, retrieves all the beans that were created either by your app or 
	 * were automatically added, thanks to Spring Boot. It sorts them and prints them out.
	 * 
	 * The @Bean annotation used below tells Spring that this method will return a CommandLineRunner object 
	 * that should be registered as a bean in the Spring application context.
	 * 
	 * @param ctx
	 * @return
	 */
	@Bean
	@Description("Upon Spring start up, retrieves all the beans that were created either by our app or were automatically added thanks to Spring Boot.")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            log.info("Let's inspect the beans provided by Spring Boot for JPA:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            
            log.debug("Spring Data JPA related beans:");
            for (String beanName : beanNames) {
	        	if(beanName.contains(".data") 
	        			|| beanName.contains("hibernate") 
	        			|| beanName.contains(".jpa") 
	        			|| beanName.contains("Template")) 
	        		log.debug(beanName);
            }
        	
            log.info("Total Beans available in the Spring Container: " + ctx.getBeanDefinitionCount());

        };
    }
	
}

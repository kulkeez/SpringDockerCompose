package com.kulkeez.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

import com.kulkeez.demo.exceptions.EmployeeNotFoundException;
import com.kulkeez.demo.model.Employee;
import com.kulkeez.demo.service.EmployeeService;

/**
 * 
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests. 
 * 
 * @author <a href="mailto:kulkeez@yahoo.com">Vikram Kulkarni</a> 
 *
 */
@RestController
@Slf4j
public class EmployeeController {

    @Autowired
	EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> findAllEmployees() {
        return employeeService.retrieveAllEmployees();
    }

    @GetMapping("/employees/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		Employee employee = employeeService.retrieveEmployeeById(employeeId);
				            //.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}      
}

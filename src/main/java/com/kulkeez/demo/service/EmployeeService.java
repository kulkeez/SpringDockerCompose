package com.kulkeez.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kulkeez.demo.model.Employee;
import com.kulkeez.demo.repository.EmployeeRepository;


/**
 * 
 * 
 */
@Component
public class EmployeeService {

    @Autowired EmployeeRepository repository;

    /**
     * Return all Employees 
     * 
     * @return List of all Employees
     */
    public List<Employee> retrieveAllEmployees() {
        return repository.findAll();
    }
}

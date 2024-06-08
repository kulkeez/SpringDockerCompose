package com.kulkeez.demo.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kulkeez.demo.model.Employee;


/**
 * 
 * 
 * @author <a href="mailto:kulkeez@yahoo.com">Vikram Kulkarni</a> 
 *
 */
// The @Repository annotation is a specialization of the @Component annotation 
// and marks this java class as a bean so the component-scanning mechanism of Spring can pick it up 
// and pull it into the application context.
@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

}

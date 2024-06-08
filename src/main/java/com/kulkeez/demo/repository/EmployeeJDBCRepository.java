package com.kulkeez.demo.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kulkeez.demo.model.Employee;


/**
 * 
 * 
 * @author kulkeez
 *
 */
// The @Repository annotation is a specialization of the @Component annotation 
// and marks this java class as a bean so the component-scanning mechanism of Spring can pick it up 
// and pull it into the application context.
@Repository
public class EmployeeJDBCRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
    }
    
    public Optional<Employee> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM EMPLOYEE WHERE ID = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Employee(
                                rs.getLong("ID"),
                                rs.getString("FIRST_NAME"),
                                rs.getString("LAST_NAME"),
                                rs.getString("ADDRESS")
                        ))
        );
    }
    
    public int create(Employee emp) {
        return jdbcTemplate.update(
                "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, ADDRESS) values(?,?,?,?)",
                emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getAddress());
    }
    
    public int update(Employee emp) {
        return jdbcTemplate.update(
                "UPDATE EMPLOYEE SET LAST_NAME = ? WHERE ID = ?",
                emp.getLastName(), emp.getId());
    }
    
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "DELETE EMPLOYEE WHERE ID = ?",
                id);
    }
    
}

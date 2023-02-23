package com.imaginnovate.etd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.etd.models.Employee;
import com.imaginnovate.etd.services.EmployeeService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	@Autowired	
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
		
	        Employee savedEmployee = employeeService.createEmployee(employee);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }
	
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeesTaxDeduction(){
        List<Employee> Employee = employeeService.getEmployeesTaxDeduction();
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

}

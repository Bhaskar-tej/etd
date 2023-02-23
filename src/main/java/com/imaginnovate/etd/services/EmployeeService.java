package com.imaginnovate.etd.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imaginnovate.etd.models.Employee;

@Component
public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	List<Employee> getEmployeesTaxDeduction();

}

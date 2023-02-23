package com.imaginnovate.etd.services;

import java.math.BigDecimal;
import java.time.*;
import java.util.List;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.etd.models.Employee;
import com.imaginnovate.etd.repository.EmployeeRepository;


@Service
public class EmployeeServicesImplement implements EmployeeService{
	
	
	@Autowired	
	 EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		
		 return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesTaxDeduction() {
		final int year = LocalDate.now().getYear();
	    int startMonth = Month.APRIL.getValue();
	    int endMonth = Month.MARCH.getValue();
	   

	    // Get all employees from the database
	    List<Employee> employees = employeeRepository.findAll();

	    List<Employee> employeeTaxDtos = employees.stream().map(employee -> {
	    	BigDecimal sal = new BigDecimal(employee.getSalary());
	        BigDecimal yearlySalary = sal.multiply(new BigDecimal(12));
	        BigDecimal taxableIncome = yearlySalary.subtract(new BigDecimal(250000));
	        BigDecimal taxAmount = BigDecimal.ZERO;
	        BigDecimal cessAmount = BigDecimal.ZERO;
	        if (taxableIncome.compareTo(BigDecimal.ZERO) > 0) {
	            if (taxableIncome.compareTo(new BigDecimal(250000)) <= 0) {
	                taxAmount = taxableIncome.multiply(new BigDecimal(0.05));
	            } else if (taxableIncome.compareTo(new BigDecimal(500000)) <= 0) {
	                taxAmount = taxableIncome.subtract(new BigDecimal(250000)).multiply(new BigDecimal(0.1)).add(new BigDecimal(12500));
	            } else if (taxableIncome.compareTo(new BigDecimal(750000)) <= 0) {
	                taxAmount = taxableIncome.subtract(new BigDecimal(500000)).multiply(new BigDecimal(0.15)).add(new BigDecimal(37500));
	            } else {
	            	 taxAmount = taxableIncome.subtract(new BigDecimal(750000)).multiply(new BigDecimal(0.2)).add(new BigDecimal(75000));
	            }
	            cessAmount = taxAmount.multiply(new BigDecimal(0.04));
	        }
	        return new Employee(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
	                yearlySalary, taxAmount, cessAmount);
	    }).collect(Collectors.toList());

	    // Filter employees by the current financial year and return the response
	    List<Employee> filteredEmployees = employeeTaxDtos.stream().filter(employeeTaxDto -> {
	    	LocalDate date = LocalDate.ofInstant(employeeTaxDto.getDoj().toInstant(), ZoneId.systemDefault());
	        LocalDate joiningDate =  date;
	        return joiningDate.getMonthValue() >= startMonth || joiningDate.getYear() > year;
	    }).collect(Collectors.toList());

	    return filteredEmployees;
	}
	
}

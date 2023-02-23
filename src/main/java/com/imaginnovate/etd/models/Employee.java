package com.imaginnovate.etd.models;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@NotBlank(message = "Should not be null")
	@Size(max=25,message = "Not more than 25 letters")
	@Column(name="firstName",nullable = false)
	private String firstName;
	
	@NotBlank(message = "Should not be null")
	@Size(max=25,message = "Not more than 25 letters")
	@Column(name="lastName",nullable = false)
	private String lastName;
	
	@NotBlank(message = "Should not be null")
	@Email(message = "Enter valid email")
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@NotBlank(message = "Should not be null")
	@Column(name="phoneNumber",nullable = false)
	private long phoneNumber;
	
	@NotBlank(message = "Should not be null")
	@Column(name="doj",nullable = false)
	private Date doj;
	
	@NotBlank(message = "Should not be null")
	@Column(name="salary",nullable = false)
	private double salary;
	
	private BigDecimal yearlySalary;
	private BigDecimal taxAmount; 
	private BigDecimal cessAmount;
	
	public Employee(int employeeId, String firstName, String lastName, String email, long phoneNumber, Date doj,
			double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
	}
	public Employee(int employeeId, String firstName, String lastName, BigDecimal yearlySalary, BigDecimal taxAmount,BigDecimal cessAmount) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public BigDecimal getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(BigDecimal yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public BigDecimal getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(BigDecimal cessAmount) {
		this.cessAmount = cessAmount;
	}
	

}

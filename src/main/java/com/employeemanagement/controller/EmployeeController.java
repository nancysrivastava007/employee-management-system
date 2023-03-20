package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody EmployeeDto employeeDto){
		employeeService.addEmployee(employeeDto);
	}

	// displaying list of all employees
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployee(){
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/employees/{id}")
	public EmployeeDto getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}	

	//updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id){
		employeeService.updateEmployee(employeeDto, id);
	}

	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees(){
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody EmployeeDto e, @PathVariable int id){
		employeeService.deleteEmployeeByID(id);
	}
}

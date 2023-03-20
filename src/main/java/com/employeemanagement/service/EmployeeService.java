package com.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.converter.EmployeeConverter;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.EmployeeEntity;
import com.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeConverter employeeConverter;

	// inserting employee
	public void addEmployee(EmployeeDto dto) {
		employeeRepository.save(employeeConverter.toEntity(dto));
	}

	// fetching all employees
	public List<EmployeeDto> getAllEmployees(){
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntityList = (List<EmployeeEntity>)employeeRepository.findAll();
		if(employeeEntityList.size() != 0) {
			for(EmployeeEntity entity: employeeEntityList)
				employeeDtoList.add(employeeConverter.toDto(entity));			
		}
		return employeeDtoList;
	}

	// fetching employee by id
	public EmployeeDto getEmployee(int id){
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		if(employeeEntity != null) {
			return employeeConverter.toDto(employeeEntity.get());
		}
		return null;
	}	

	// updating employee by id
	public void updateEmployee(EmployeeDto dto, int id){
		if(id == dto.getEmployeeId()) {
			employeeRepository.save(employeeConverter.toEntity(dto));
		}
	}

	// deleting all employees
	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(int id){
		employeeRepository.deleteById(id);
	}
}

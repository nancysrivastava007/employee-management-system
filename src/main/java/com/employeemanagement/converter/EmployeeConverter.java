package com.employeemanagement.converter;

import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.DepartmentEntity;
import com.employeemanagement.entity.EmployeeEntity;

public class EmployeeConverter {
	
	public EmployeeEntity toEntity(EmployeeDto dto) {
		return EmployeeEntity.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.department(DepartmentEntity.builder()
						.departmentId(dto.getDepartment().getDepartmentId())
						.departmentName(dto.getDepartment().getDepartmentName())
						.departmentDescription(dto.getDepartment().getDepartmentDescription())
						.build())
				.build();		
	}
	
	public EmployeeDto toDto(EmployeeEntity entity) {
		return EmployeeDto.builder()
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.department(DepartmentDto.builder()
						.departmentId(entity.getDepartment().getDepartmentId())
						.departmentName(entity.getDepartment().getDepartmentName())
						.departmentDescription(entity.getDepartment().getDepartmentDescription())
						.build())
				.build();		
	}
}

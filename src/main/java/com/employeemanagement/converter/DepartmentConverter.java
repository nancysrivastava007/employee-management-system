package com.employeemanagement.converter;

import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.entity.DepartmentEntity;

public class DepartmentConverter {
	
	public DepartmentEntity toEntity(DepartmentDto dto) {
		return DepartmentEntity.builder()
				.departmentName(dto.getDepartmentName())
				.departmentDescription(dto.getDepartmentDescription())
				.build();		
	}
	
	public DepartmentDto toDto(DepartmentEntity entity) {
		return DepartmentDto.builder()
				.departmentName(entity.getDepartmentName())
				.departmentDescription(entity.getDepartmentDescription())
				.build();		
	}
}

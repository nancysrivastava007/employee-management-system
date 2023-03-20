package com.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private int employeeId;
	private String firstName;
	private String lastName;
	private DepartmentDto department;
}
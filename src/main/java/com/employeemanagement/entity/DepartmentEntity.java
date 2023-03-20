package com.employeemanagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="department")
public class DepartmentEntity {

	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_description")
	private String departmentDescription;
	
	@OneToMany
	private List<EmployeeEntity> employees;
}

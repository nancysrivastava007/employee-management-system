package com.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.converter.DepartmentConverter;
import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.entity.DepartmentEntity;
import com.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentConverter departmentConverter;
	

	// fetching all department
	public List<DepartmentDto> getAllDepartments(){
		List<DepartmentDto> departmentDtoList = new ArrayList<>();
		List<DepartmentEntity> departmentEntityList = (List<DepartmentEntity>)departmentRepository.findAll();
		if(departmentEntityList.size() != 0) {
			for(DepartmentEntity entity: departmentEntityList)
			departmentDtoList.add(departmentConverter.toDto(entity));			
		}
		return departmentDtoList;
	}
	
	// fetching department by id
	public DepartmentDto getDepartment(int id){
		Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
		if(departmentEntity != null) {
			return departmentConverter.toDto(departmentEntity.get());
		}
		return null;
	}
	
	// inserting department
	public void addDepartment(DepartmentDto dto) {
		departmentRepository.save(departmentConverter.toEntity(dto));
	}
	
	// updating department by id
	public void updateDepartment(DepartmentDto dto, int id){
		if(id == dto.getDepartmentId()) {
			departmentRepository.save(departmentConverter.toEntity(dto));
		}
	}
	
	// deleting all departments
	public void deleteAllDepartment(){
		departmentRepository.deleteAll();
	}
	
	// deleting department by id
	public void deleteDepartmentByID(int id){
		departmentRepository.deleteById(id);
	}
}

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

import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// displaying list of all department
	@GetMapping("/departments")
	public List<DepartmentDto> getAllDepartment(){
		return departmentService.getAllDepartments();
	}

	// displaying department by id
	@GetMapping("/departments/{id}")
	public DepartmentDto getDepartment(@PathVariable int id){
		return departmentService.getDepartment(id);
	}

	// inserting department
	@PostMapping("/departments")
	public void addDepartment(@RequestBody DepartmentDto department){
		departmentService.addDepartment(department);
	}

	//updating department by id
	@PutMapping("/departments/{id}")
	public void updateDepartment(@RequestBody DepartmentDto d, @PathVariable int id){
		departmentService.updateDepartment(d, id);
	}

	// deleting all department
	@DeleteMapping("/departments")
	public void deleteAllDepartments(){
		departmentService.deleteAllDepartment();
	}

	// deleting department by id
	@DeleteMapping("departments/{id}")
	public void deleteDepartmentByID(@RequestBody DepartmentDto d, @PathVariable int id){
		departmentService.deleteDepartmentByID(id);
	}
}

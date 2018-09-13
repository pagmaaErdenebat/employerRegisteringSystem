package com.pagmaa.demo.employeeRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagmaa.demo.employeeRegistration.entity.Employee;
import com.pagmaa.demo.employeeRegistration.service.EmployeeService;
import com.pagmaa.demo.employeeRegistration.util.EmployeeNotFoundException;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employee) {
		employeeService = employee;
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") Integer id) {

		Employee employee = new Employee();
		employee = employeeService.getEmployee(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + id);
		}

		return employee;
	}


	@GetMapping("/list")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@PostMapping("/saveupdate")
	public Employee save(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/saveupdate")
	public Employee update(@RequestBody Employee theEmployee) {

		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		Employee theEmployee = new Employee();
		
		theEmployee=employeeService.getEmployee(id);
		
		if (theEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found---"+ id);
		}
		employeeService.delete(id);
		return "Deleted Employee Id --" + id;
	}
}

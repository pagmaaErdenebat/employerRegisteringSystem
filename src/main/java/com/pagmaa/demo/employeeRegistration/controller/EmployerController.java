package com.pagmaa.demo.employeeRegistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagmaa.demo.employeeRegistration.entity.Employee;
import com.pagmaa.demo.employeeRegistration.entity.Employer;
import com.pagmaa.demo.employeeRegistration.service.EmployeeService;
import com.pagmaa.demo.employeeRegistration.service.EmployerService;

@RestController
@RequestMapping("/employer")
public class EmployerController {

	private final EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {

		this.employerService = employerService;
	}

	@GetMapping(value = "/{id}")
	public Employer getById(@PathVariable("id") Integer employerId) {
		return employerService.findById(employerId);
	}

	@GetMapping(value = "/list")
	public List<Employer> getEmployers() {
		return employerService.findAll();
	}

	@PostMapping("/saveupdate")
	public Employer save(@RequestBody Employer theEmployer) {

		theEmployer.setId(0);
		employerService.saveupdate(theEmployer);
		return theEmployer;
	}

	@PutMapping("/saveupdate")
	public Employer update(@RequestBody Employer theEmployer) {

		employerService.saveupdate(theEmployer);
		return theEmployer;
	}
}

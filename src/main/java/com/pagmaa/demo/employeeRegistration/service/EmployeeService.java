package com.pagmaa.demo.employeeRegistration.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pagmaa.demo.employeeRegistration.entity.Employee;

@Transactional(readOnly = true)
public interface EmployeeService {
	
	public Employee getEmployee(Integer id);
	
	public List<Employee> findByFirstName(String name);

	public List<Employee> findAll();
	
	@Transactional    
	Employee save(Employee employee);

    @Transactional    
    void delete(Integer id);
}

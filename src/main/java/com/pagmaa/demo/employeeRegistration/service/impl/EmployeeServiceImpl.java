package com.pagmaa.demo.employeeRegistration.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagmaa.demo.employeeRegistration.entity.Employee;
import com.pagmaa.demo.employeeRegistration.repository.EmployeeRepo;
import com.pagmaa.demo.employeeRegistration.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		logger.info("get employee by id" + id);
		return employeeRepo.getOne(id);
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		logger.info("saving employee: " + employee.getFirstName() + " " + employee.getLastName());
		return employeeRepo.save(employee);
	}

	@Override
	public void delete(Integer id) {
		logger.info("deleting employee: " + id);
		employeeRepo.deleteById(id);
	}

	@Override
	public List<Employee> findByFirstName(String name) {
		// TODO Auto-generated method stub
		logger.info("searching employee by name: " + name);
		return employeeRepo.findByFirstName(name);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		logger.info("searching all employee");
		return employeeRepo.findAll();
	}

}

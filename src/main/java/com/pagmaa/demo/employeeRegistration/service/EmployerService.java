package com.pagmaa.demo.employeeRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.pagmaa.demo.employeeRegistration.entity.Employer;

@Transactional(readOnly = true)
public interface EmployerService {
	
	public Employer findById(Integer id);
		
	public List<Employer> findByName(String name);
	
	public List<Employer> findAll();
	
	@Transactional
	public Employer saveupdate(Employer employer);
	
	@Transactional
	public void delete(Integer id);	
}
package com.pagmaa.demo.employeeRegistration.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagmaa.demo.employeeRegistration.entity.Employer;
import com.pagmaa.demo.employeeRegistration.repository.EmployerRepo;
import com.pagmaa.demo.employeeRegistration.service.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {

	private static final Logger logger = LogManager.getLogger(EmployerServiceImpl.class);
	
	@Autowired
	private EmployerRepo employerRepo;

	@Override
	public Employer findById(Integer id) {
		// TODO Auto-generated method stub
		logger.info("getting employer by id" + id);
		return employerRepo.getOne(id);
	}

	@Override
	public List<Employer> findByName(String name) {
		// TODO Auto-generated method stub
		logger.info("finding employers by name" + name);
		return employerRepo.findByName(name);
	}

	@Override
	public List<Employer> findAll() {
		// TODO Auto-generated method stub
		logger.info("getting all employers");
		return employerRepo.findAll();
	}

	@Override
	public Employer saveupdate(Employer employer) {
		// TODO Auto-generated method stub
		logger.info("saving employer: " + employer.getName());
		return employerRepo.save(employer);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		logger.info("deletings employer by id" + id);
		employerRepo.deleteById(id);
	}
	
	
	
	
	

}

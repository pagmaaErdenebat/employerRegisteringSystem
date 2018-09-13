package com.pagmaa.demo.employeeRegistration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pagmaa.demo.employeeRegistration.entity.Employer;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Integer> {

	@Query("SELECT a FROM Employer a WHERE " +
            "(:name IS NULL OR a.name like %:name%)")
	public List<Employer> findByName(String name);	
	
}

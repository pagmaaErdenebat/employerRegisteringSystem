package com.pagmaa.demo.employeeRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pagmaa.demo.employeeRegistration.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//@Query("SELECT a FROM Employee a WHERE " + "(:name IS NULL OR a.name like %:name%)")
	public List<Employee> findByFirstName(String name);


}

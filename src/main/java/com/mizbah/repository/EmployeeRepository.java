package com.mizbah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mizbah.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);
}

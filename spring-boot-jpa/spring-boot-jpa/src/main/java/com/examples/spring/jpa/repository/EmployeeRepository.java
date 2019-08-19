package com.examples.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.spring.jpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

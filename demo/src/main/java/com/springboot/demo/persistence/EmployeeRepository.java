package com.springboot.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.domain.Employee;

/**
 * Jpa repository contract for an employee
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

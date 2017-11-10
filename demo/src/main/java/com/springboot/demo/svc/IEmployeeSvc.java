package com.springboot.demo.svc;

import java.util.List;

import com.springboot.demo.domain.Employee;

public interface IEmployeeSvc {

	public Employee save(Employee employee);

	public List<Employee> findAll();
	
	public Employee find(long id);
	
	public void delete(long id);
}

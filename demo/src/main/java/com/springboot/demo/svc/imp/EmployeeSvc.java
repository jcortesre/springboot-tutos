package com.springboot.demo.svc.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.domain.Employee;
import com.springboot.demo.persistence.EmployeeRepository;
import com.springboot.demo.svc.IEmployeeSvc;

/**
 * Default implementation of {@link IEmployeeSvc}
 */
@Service
public class EmployeeSvc implements IEmployeeSvc {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee find(long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(long id) {
		if (repository.exists(id)) {
			repository.delete(id);
		}
	}
}

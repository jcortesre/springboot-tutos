package com.springboot.demo.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.domain.CustomError;
import com.springboot.demo.domain.Employee;
import com.springboot.demo.svc.IEmployeeSvc;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

	@Autowired
	private IEmployeeSvc service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee saved = service.save(employee);
		return ResponseEntity.ok(saved);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employees = service.findAll();
		return ResponseEntity.ok(employees);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable("id") long id) {
		Employee emp = service.find(id);
		if (emp == null) {
			return formatResponseError(id);
		}
		return ResponseEntity.ok(emp);
	}

	private ResponseEntity<?> formatResponseError(long id) {
		return new ResponseEntity<CustomError>(new CustomError("User with id " + id + " not found"),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> delete(@PathVariable("id") long id) {
		service.delete(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}

package com.example.demo.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;

@RestController
public class EmployeeResource {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {
		
		return buildEmployee();
	}

	private Employee buildEmployee() {
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		return emp;
	}

}

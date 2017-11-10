package com.springboot.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.domain.Employee;
import com.springboot.demo.svc.IEmployeeSvc;

/**
 * Employee controller using jsp
 */
@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeSvc service;

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
	public String save(Employee employee) {
		service.save(employee);
		return "redirect:/listEmployees.html";
	}

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {
		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);
	}

	@RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<Employee> employees = service.findAll();
		return new ModelAndView("allEmployees", "employees", employees);
	}

}

package com.jrp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@Controller
@RequestMapping("/employee")
public class employeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping ("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		model.addAttribute ("employee", anEmployee);
		return "new-employee";
	}
	
	@PostMapping ("/save")
	public String createEmployee(Employee employee, Model model) {
		//empRepo.save(employee);
		empRepo.save(employee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employee/new";
	}
}

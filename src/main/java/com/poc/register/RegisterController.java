package com.poc.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@GetMapping(value = "/hi")
	public String hi() {
		return "hi amrit";
	}
	
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		return registerService.getAll();
	}
	
	@PostMapping(value = "/employees")
	public void addEmployee(@RequestBody Employee employee) {
		registerService.add(employee);
	}

}

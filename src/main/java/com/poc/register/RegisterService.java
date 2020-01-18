package com.poc.register;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository repo;

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public void add(Employee employee) {
		repo.save(employee);
	}
}

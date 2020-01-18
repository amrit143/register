package com.poc.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Experience")
	private double exp;
	
	@Column(name = "Skill")
	private String skill;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Employee(long id, String name, double exp, String skill) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.skill = skill;
	}
	public Employee() {
		super();
	}
}

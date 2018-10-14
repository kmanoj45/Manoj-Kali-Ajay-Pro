package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="emps")
public class Employee {
	@Id
	private int empid;
	@Column(length=30,name="ename")
	private String name;
	@Column(length=30)
	private String city;
	private int sal;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Employee(int empid, String name, String city, int sal) {
		super();
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.sal = sal;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

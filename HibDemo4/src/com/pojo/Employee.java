package com.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
	@Id	
	private int empid;
	@Column(length=30)
	private String name;
	@Column(length=30)
	private String city;
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public Employee(int empid, String name, String city, Date dob) {
		super();
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.dob = dob;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDob() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		return sdf.format(dob);
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
}

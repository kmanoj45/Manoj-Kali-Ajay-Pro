package com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="stds")
public class Student {
	@Id
	private int rollno;
	@Column(length=30)
	private String name;
	@Column(length=25)
	private String city;
	private LocalDate dob;
	
	public Student() {
		super();
	}
	public Student(int rollno, String name, String city, LocalDate dob) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.city = city;
		this.dob = dob;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
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
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd-MMM-yyyy");				
		return dob.format(fmt);
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}

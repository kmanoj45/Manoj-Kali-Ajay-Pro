package com.example;

public class Student {
	private int rollno;
	private String name;
	private String city;
	
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
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String name, String city) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", city=" + city + "]";
	}
	
	
}

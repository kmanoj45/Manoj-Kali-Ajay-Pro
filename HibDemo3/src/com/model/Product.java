package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="prod")
public class Product {
	@Id
	@Column(length=3)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prodid;
	@Column(length=30)
	private String pname;
	@Column(length=5)
	private int price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product( String pname, int price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
	
}

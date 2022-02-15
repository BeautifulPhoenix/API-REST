package com.example.demo;

public class author {
	
	public int id;
	public String name;
	public String country;
	public int dob;
	public int qtyBooks;
	public Boolean alive;
	
	public author () {}
	
	public author(int id, String name, String country, int dob, int qtyBooks, Boolean alive) {
		
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.dob = dob;
		this.qtyBooks = qtyBooks;
		this.alive = alive;
	}
	
	public int getid() {
		return id;
	
	}
	
	public void setid (int id) {
		this.id = id;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname (String name) {
		this.name = name;
	}
	
	public String getcountry () {
		return country;
	}
	
	public void setcountry (String country) {
		this.country = country;
		}
	
	public int getdob () {
		return dob;
		
	}
	
	public void setdob (int dob) {
		this.dob = dob;
	}
	
	public int getqtyBooks () {
		return qtyBooks;
	}
	
	public void setqtyBooks (int qtyBooks) {
		this.qtyBooks = qtyBooks;
	}
	
	public boolean getalive () {
		return alive;
	}
	
	public void setalive (boolean alive) {
		this.alive = alive;
	}
}
	
	

package com.test.code.model;

public class Student {
	
	//this is model class
    //here, we declare all fields name of table
	public int id;
	public String name;
	public String age;
	public String city;
	public String email;
	
	//this is simple constructor
	public Student() {
		
	}
	
	//this is without id constructor
	public Student(String name, String age, String city, String email) {
	
		this.name = name;
		this.age = age;
		this.city = city;
		this.email = email;
	}
	
	//this is with id constructor
	public Student(int id, String name, String age, String city, String email) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.email = email;
	}
	
	//this is Getters and Setters method
	//to get and set the values
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}

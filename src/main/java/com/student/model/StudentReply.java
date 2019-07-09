package com.student.model;

public class StudentReply {
	
	private String name;
    private int age;
    private String registrationnumber;
    private String registrationstatus;
    
	public StudentReply(String name, int age, String registrationNumber, String registrationStatus) {
		super();
		this.name = name;
		this.age = age;
		this.registrationnumber = registrationNumber;
		this.registrationstatus = registrationStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegistrationnumber() {
		return registrationnumber;
	}
	public void setRegistrationnumber(String registrationNumber) {
		this.registrationnumber = registrationNumber;
	}
	public String getRegistrationStatus() {
		return registrationstatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationstatus = registrationStatus;
	}
    

}

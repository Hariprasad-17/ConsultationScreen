package com.his.model;

import java.util.Objects;

public class Patient {
	
	private int id;
	private String name;
	private int age;
	private String address;
	private String emailAddress;
	private String bloodGroup;
	private String phoneNumber;
	private int tokenNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public int getTokenNumber() {
		return tokenNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDateOfBirth(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmailAddress(String emailaddress) {
		this.emailAddress = emailaddress;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setTokenNumber(int tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	@Override
	public String toString() {
		return id +" : "+name + " : " + tokenNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, age, bloodGroup, emailAddress, id, name, phoneNumber, tokenNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address) && age == other.age
				&& Objects.equals(bloodGroup, other.bloodGroup) && Objects.equals(emailAddress, other.emailAddress)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber)
				&& tokenNumber == other.tokenNumber;
	}
	
	
}

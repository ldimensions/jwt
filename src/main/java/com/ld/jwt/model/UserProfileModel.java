package com.ld.jwt.model;

import java.util.ArrayList;
import java.util.List;

import com.ld.jwt.entity.Address;
import com.ld.jwt.entity.Phone;

public class UserProfileModel {

	private String username;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private List<Address> address = new ArrayList<>();
	private List<Phone> phone = new ArrayList<>();
	
	public UserProfileModel() { }

	public UserProfileModel(String username, String firstName, String middleName, String lastName, String email,
			List<Address> address, List<Phone> phone) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
}

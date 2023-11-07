package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// A table in our database 
@Entity
@Table(name="students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@Column(name="email")
	private String emailId;
	
	public StudentEntity(long id, String name, String address, String contact, String district, String state,
			String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.district = district;
		this.state = state;
		this.emailId = emailId;
	}

	public StudentEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", district=" + district + ", state=" + state + ", emailId=" + emailId + "]";
	}
	
}

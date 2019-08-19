package com.examples.spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	private Long id;
	private String name;
	private String address;
	private String status;
	private String contact_no;
	private String email_id;
	
	public Employee() {	
		
	}

	public Employee(Long id, String name, String address, String status, String contact_no, String email_id ) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.status = status;
		this.contact_no  = contact_no;
		this.email_id = email_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getContact_No() {
		return  contact_no;
	}

	public void setContact_No(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_Id() {
		return email_id;
	}

	public void setEmail_Id(String email_id) {
		this.email_id = email_id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ ", status=" + status + ", contact_no=" + contact_no
				+ ", email_id=" + email_id + "]";
	}
	
	
}

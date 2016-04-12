package com.iba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PersonalDetails")
public class PersonalDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "middle_name")
	private String middle_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "father_name")
	private String father_name;
	
	@Column(name = "mother_name")
	private String mother_name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "marital_status")
	private String marital_status;
	
	@Column(name = "contact_num")
	private String contact_num;
	
	@Column(name = "PAN_num")
	private String pan_num;
	
	@Column(name = "date_of_joining")
	private String date_of_joining;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "designation")
	private  String designation;
	
	@Column(name ="location")
	private String location;

	
	// SETTERS AND GETTERS FOR ALL FIELDS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String string) {
		this.dob = string;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getPan_num() {
		return pan_num;
	}

	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
	
}

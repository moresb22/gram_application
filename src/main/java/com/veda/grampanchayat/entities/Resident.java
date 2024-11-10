package com.veda.grampanchayat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Resident {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String mobileNumber;
	private String dob;
	private String aadhaarNo;
	private String gender;
	private String address;
	private String rationCardNumber;
	private String type; // Self, Spouse, Child, Parents

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRationCardNumber() {
		return rationCardNumber;
	}

	public void setRationCardNumber(String rationCardNumber) {
		this.rationCardNumber = rationCardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Resident(Long id, String name, String mobileNumber, String dob, String aadhaarNo, String gender,
			String address, String rationCardNumber, String type) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.aadhaarNo = aadhaarNo;
		this.gender = gender;
		this.address = address;
		this.rationCardNumber = rationCardNumber;
		this.type = type;
	}

	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Resident [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", dob=" + dob
				+ ", aadhaarNo=" + aadhaarNo + ", gender=" + gender + ", address=" + address + ", rationCardNumber="
				+ rationCardNumber + ", type=" + type + "]";
	}

}

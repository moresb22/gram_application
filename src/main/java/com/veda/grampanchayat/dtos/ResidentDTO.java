package com.veda.grampanchayat.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResidentDTO {

	@NotBlank(message = "Name is required")
	private String name;

	@jakarta.validation.constraints.Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	private String dob;

	@Size(min = 12, max = 12, message = "Aadhaar number must be 12 digits")
	private String aadhaarNo;

	private String gender;

	private String address;

	private String rationCardNumber;

	@NotBlank(message = "Type is required")
	private String type; // Self, Spouse, Child, Parents

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

	@Override
	public String toString() {
		return "ResidentDTO [name=" + name + ", mobileNumber=" + mobileNumber + ", dob=" + dob + ", aadhaarNo="
				+ aadhaarNo + ", gender=" + gender + ", address=" + address + ", rationCardNumber=" + rationCardNumber
				+ ", type=" + type + "]";
	}

	public ResidentDTO(@NotBlank(message = "Name is required") String name,
			@jakarta.validation.constraints.Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits") String mobileNumber,
			String dob, @Size(min = 12, max = 12, message = "Aadhaar number must be 12 digits") String aadhaarNo,
			String gender, String address, String rationCardNumber,
			@NotBlank(message = "Type is required") String type) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.aadhaarNo = aadhaarNo;
		this.gender = gender;
		this.address = address;
		this.rationCardNumber = rationCardNumber;
		this.type = type;
	}

	public ResidentDTO() {
		super();

	}

}

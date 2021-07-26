package com.akhilesh.techademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	int user_id;
	
	String name, phone_no, email, reg_date, password, address, upload_photo;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUpload_photo() {
		return upload_photo;
	}
	
	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", phone_no=" + phone_no + ", email=" + email + ", reg_date="
				+ reg_date + ", password=" + password + ", address=" + address + "]";
	}
	
	
}

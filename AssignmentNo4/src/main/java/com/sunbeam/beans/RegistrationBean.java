package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private int status;
	private String role;
	private int count;
	
	
	public RegistrationBean() {
		
	}
	
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void registerUser() {
		Date dob = Date.valueOf(birth);
		User user = new User(0,firstName,lastName,email,password,dob,status,role);
		try(UserDao userDao = new UserDaoImpl()){
			count = userDao.save(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

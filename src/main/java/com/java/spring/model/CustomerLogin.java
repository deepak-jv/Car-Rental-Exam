package com.java.spring.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//import jakarta.validation.constraints.NotNull;


@Entity
public class CustomerLogin {

	@NotNull
	@Size(min = 1,message = "is required")
	private String name;
	@NotNull
	@Size(min = 1,message = "is required")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.java.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "bookings")
public class CustomerBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String name;
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String contact;
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String address;
	
	@NotNull
	@Size(min = 1,message = "is required")
//	@ManyToOne(cascade = {CascadeType.DETACH ,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private String car;
	
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String carType;
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String payment;
	
	@NotNull
	@Size(min = 1,message = "is required")
	private String day;

	private String status;
	private String charge;
	
	
	
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

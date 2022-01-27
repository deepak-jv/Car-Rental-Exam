package com.java.spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String car;
	private String carType;
	private int charge;

	
//	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	@JoinTable(name = "car_carType",joinColumns = @JoinColumn(name="car_id"),
//	inverseJoinColumns = @JoinColumn(name="carType_id"))

	
	

	
	
	public int getId() {
		return id;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	

//	public List<CarType> addCarType(CarType type){
//		
//		if (carType == null) {
//		carType = new ArrayList<CarType>();
//		}
//		
//		carType.add(type);	
//		
//		
//		
//		return carType;
//		
//	}

	
	

}

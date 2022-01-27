//package com.java.spring.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//import org.hibernate.annotations.ManyToAny;
//
//
//@Entity
//public class CarType {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id ;
//	
//	private String carType;
//
//	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	@JoinTable(name = "car_carType", joinColumns = @JoinColumn(name = "carType_id"), inverseJoinColumns = @JoinColumn(name = "car_id"))
//	private List<Car> car;
//	
//	
//	
//
//
//
//	public String getCarType() {
//		return carType;
//	}
//
//	public void setCarType(String carType) {
//		this.carType = carType;
//	}
//
//	public List<Car> getCar() {
//		return car;
//	}
//
//	public void setCar(List<Car> car) {
//		this.car = car;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void addCar(Car tempcar) {
//
//		if (car == null) {
//			car = new ArrayList<Car>();
//		}
//		car.add(tempcar);
//	}
//	
//	
//}
//
//

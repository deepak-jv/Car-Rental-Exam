package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.spring.model.Car;

public interface CarDao {

	public int save(Car car) throws SQLException;
//	public int save(CarType cartype) throws SQLException;
	public List<Car> getAll() throws SQLException;
	
}

package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.spring.model.Car;

@Repository
public class CarDaoImpl implements CarDao {
	@Autowired
	HibernateTemplate hibernateTamplate;

	@Transactional
	public int save(Car car) throws SQLException {

		Integer i = (Integer) this.hibernateTamplate.save(car);
		return i;
	}

	@Transactional
	public List<Car> getAll() throws SQLException {
		
		List<Car> cars = this.hibernateTamplate.loadAll(Car.class);
		
		return cars;
	}

//	public int save(CarType cartype) throws SQLException {
//		Integer i = (Integer) this.hibernateTamplate.save(cartype);
//		return i;
//	}

}

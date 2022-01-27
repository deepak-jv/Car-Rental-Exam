package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import com.java.spring.model.Car;
import com.java.spring.model.CustomerRegistration;

public interface CustomerRegisterDao {
	public int save(CustomerRegistration custumer_reg) throws SQLException;
	public List<CustomerRegistration> getAll() throws SQLException;
	public CustomerRegistration findByPassword(String password) throws SQLException;	 
	public CustomerRegistration findByName(String name) throws SQLException;	 
}

package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.spring.model.CustomerBooking;
import com.java.spring.model.CustomerRegistration;


public interface CustomerBookingDao {
	
	public int save(CustomerBooking booking) throws SQLException;
	public void update( String name,String contact,String address, String car,String carType,String payment,String status,int id,String charge) throws SQLException; 
	public List<CustomerBooking> getAll() throws SQLException;
	public CustomerBooking findByName(String name) throws SQLException;	 
	public CustomerBooking findById(int id) throws SQLException;
	public List<CustomerBooking> getNameList(String name) throws SQLException;
	public void delete(Integer id) throws SQLException;


}

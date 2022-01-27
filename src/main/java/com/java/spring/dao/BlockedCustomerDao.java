package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.spring.model.BlockedCustomers;
import com.java.spring.model.Car;
import com.java.spring.model.CustomerBooking;

public interface BlockedCustomerDao {

	public int save (BlockedCustomers blocked) throws SQLException;
	public List<BlockedCustomers> getAll() throws SQLException;
	public BlockedCustomers findByName(String name) throws SQLException;
	public void delete(Integer id) throws SQLException;


	
}

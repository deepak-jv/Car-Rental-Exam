package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.spring.model.BlockedCustomers;
import com.java.spring.model.Car;
import com.java.spring.model.CustomerBooking;

@Repository
public class BlockedCustomerDaoImpl implements BlockedCustomerDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int save(BlockedCustomers blocked) throws SQLException {

		Integer i = (Integer) this.hibernateTemplate.save(blocked);
		return i;

	}
	
	
	@Transactional
	public List<BlockedCustomers> getAll() throws SQLException {
		
		List<BlockedCustomers> users = this.hibernateTemplate.loadAll(BlockedCustomers.class);
		
		return users;
	}

	@Transactional
	public BlockedCustomers findByName(String name) throws SQLException {

		return (BlockedCustomers) this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerBooking.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}
	
	@Transactional
	public void delete(Integer id) throws SQLException {

		BlockedCustomers user = this.hibernateTemplate.get(BlockedCustomers.class, id);
		this.hibernateTemplate.delete(user);
		
	}

}

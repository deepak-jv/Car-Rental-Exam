package com.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.spring.model.CustomerRegistration;

@Repository
public class CustomerRegDaoImpl implements CustomerRegisterDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	private List<CustomerRegistration> find;
	@Transactional
	public int save(CustomerRegistration custumer_reg) throws SQLException {
		Integer i = (Integer) hibernateTemplate.save(custumer_reg);
		return i ;
	}
	
	@Transactional
	public List<CustomerRegistration> getAll() throws SQLException {
		
		List<CustomerRegistration> customer = this.hibernateTemplate.loadAll(CustomerRegistration.class);
		
		return customer;
	}
	@Transactional	
	public CustomerRegistration findByPassword(String password) {

	 return	(CustomerRegistration) this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerRegistration.class)
		.add(Restrictions.eq("password", password)).uniqueResult();
		
		
	}
	
	@Transactional	
	public CustomerRegistration findByName(String name) {
		
		return	(CustomerRegistration) this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerRegistration.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
		
		
	}

	
	
	
}

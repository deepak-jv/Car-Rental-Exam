package com.java.spring.dao;

import java.sql.SQLException;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.spring.model.CustomerBooking;
import com.java.spring.model.CustomerRegistration;

@Repository
public class CustomerBookingDaoImpl implements CustomerBookingDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int save(CustomerBooking booking) throws SQLException {

		Integer i = (Integer) this.hibernateTemplate.save(booking);
		
		return i;
	}
	
	@Transactional
	public List<CustomerBooking> getAll() throws SQLException {
			List<CustomerBooking> booking = this.hibernateTemplate.loadAll(CustomerBooking.class);
		
		return booking;
	}
	@Transactional
	public CustomerBooking findByName(String name) throws SQLException {
		return (CustomerBooking) this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerBooking.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}
	@Transactional
	public CustomerBooking findById(int id) throws SQLException {
		return (CustomerBooking) this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerBooking.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Transactional
	public void update( String name,String contact,String address, String car,String carType,String payment,String status,int id,String charge) throws SQLException {

		CustomerBooking booking = this.hibernateTemplate.get(CustomerBooking.class, id);
		
		booking.setName(name);
		booking.setContact(contact);
		booking.setAddress(address);
		booking.setCar(car);
		booking.setCarType(carType);
		booking.setPayment(payment);
		booking.setStatus(status);
		booking.setCharge(charge);
		this.hibernateTemplate.update(booking);

	}
	@Transactional
	public List<CustomerBooking> getNameList(String name) throws SQLException{
		
		@SuppressWarnings("unchecked")
		List<CustomerBooking> customer1 = this.hibernateTemplate.getSessionFactory().openSession().createCriteria(CustomerBooking.class)
		.add(Restrictions.eq("name", name)).list();
		
		
		return customer1;
	}
	@Transactional
	public void delete(Integer id) throws SQLException {

		CustomerBooking booking = this.hibernateTemplate.get(CustomerBooking.class, id);
		this.hibernateTemplate.delete(booking);
		
	}





}

//package com.java.spring.dao;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.java.spring.model.CarType;
//
//@Repository
//public class CarTypeDaoImpl implements CarTypeDao {
//	@Autowired
//	HibernateTemplate hibernateTamplate;
//
//	@Transactional
//	public int save(CarType cartype) throws SQLException {
//		Integer i = (Integer) this.hibernateTamplate.save(cartype);
//		return i;
//	}
//
//	@Transactional
//	public List<CarType> getAll() throws SQLException {
//
//		List<CarType> carType = this.hibernateTamplate.loadAll(CarType.class);
//		
//		return carType;
//	}
//
//
//
//}

//import java.util.List;
//
//import javax.persistence.Entity;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//
//import com.java.spring.model.Car;
//import com.java.spring.model.CarType;
//
//@Entity
//public class CarTest {
//
//	@Autowired
//	static
//	SessionFactory sessionFactory;
//	public static void main (String[] args) {
//	
//	
//	Session session = 	sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		Car car1 = new Car();
//		Car car2 = new Car();
//		Car car3 = new Car();
//		Car car4 = new Car();
//		car1.setCar("swift");
//		car1.setCar("thar");
//		car1.setCar("fortuner");
//		car1.setCar("innova");
//		
//		CarType carType1 = new CarType();
//		CarType carType2 = new CarType();
//		CarType carType3 = new CarType();
//		carType1.setCarType("a.c.");
//		carType1.setCarType("non a.c.");
//		carType1.setCarType("safari");
//		
//		car1.setCarType(carType1);
//		car1.setCarType(carType2);
//		car1.setCarType(carType3);
//		
//		car2.setCarType(carType1);
//		car2.setCarType(carType2);
//		car2.setCarType(carType3);
//		
//		car3.setCarType(carType1);
//		car3.setCarType(carType2);
//		car3.setCarType(carType3);
//		
//		carType1.addcar(car1);
//		carType1.addcar(car2);
//		carType1.addcar(car3);
//		carType1.addcar(car4);
//				
//		
//		carType2.addcar(car1);
//		carType2.addcar(car2);
//		carType2.addcar(car3);
//		carType2.addcar(car4);
//		
//		
//		carType3.addcar(car1);
//		carType3.addcar(car2);
//		carType3.addcar(car3);
//		carType3.addcar(car4);
//		
//		
//		
//		session.save(car1);
//		session.save(car2);
//		session.save(car3);
//		session.save(car4);
//		session.save(carType1);
//		session.save(carType2);
//		session.save(carType3);
//		
//		session.getTransaction().commit();
//		System.out.println("done");
//		
//		session.close();
//		
//		
//		
//	}
//
//}

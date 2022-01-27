package com.java.spring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.java.spring.dao.BlockedCustomerDao;
import com.java.spring.dao.CarDao;
import com.java.spring.dao.CustomerBookingDao;
import com.java.spring.dao.CustomerRegisterDao;
import com.java.spring.model.BlockedCustomers;
import com.java.spring.model.Car;
import com.java.spring.model.CustomerBooking;
import com.java.spring.model.CustomerLogin;
import com.java.spring.model.CustomerRegistration;

@Controller
public class systemController {
	@Autowired
	CarDao carDao;
	@Autowired
	CustomerRegisterDao custumerDao;
	@Autowired
	CustomerBookingDao customerBookingDao;
	@Autowired
	BlockedCustomerDao blockedCustomer;

	@RequestMapping("home")
	public String carDetail(@ModelAttribute("car") Car car, Model model, @RequestParam("msg") String msg)
			throws SQLException {
		List<Car> cars = this.carDao.getAll();
		model.addAttribute("cars", cars);
		model.addAttribute("msg", msg);
		return "home";
	}

	@RequestMapping("addCar")
	public String addCars(Model model) {

		Car car = new Car();
		model.addAttribute("car", car);
		return "cars";
	}

	@RequestMapping(value = "saveCar", method = RequestMethod.POST)
	public String saveCar(Model model, @ModelAttribute("car") Car car) throws SQLException {

//		// ------------Swift
		if (car.getCar().equals("Swift")) {
			if ((car.getCarType().equals("a.c."))) {
				car.setCharge(50);
			} else if ((car.getCarType().equals("non a.c."))) {
				car.setCharge(30);
			} else if ((car.getCarType().equals("safari"))) {
				car.setCharge(40);
			}
		}

		// ------------Thar
		if (car.getCar().equals("Thar")) {
			if (car.getCarType().equals("a.c.")) {
				car.setCharge(80);
			} else if (car.getCarType().equals("non a.c.")) {
				car.setCharge(50);
			} else if (car.getCarType().equals("safari")) {
				car.setCharge(55);
			}
		}
		// ------------Innova
		else if (car.getCar().equals("Innova")) {
			if (car.getCarType().equals("a.c.")) {
				car.setCharge(70);
			} else if (car.getCarType().equals("non a.c.")) {
				car.setCharge(50);
			} else if (car.getCarType().equals("safari")) {
				car.setCharge(60);

			}
		}
		// ------------Fortuner
		else if (car.getCar().equals("Fortuner")) {
			if (car.getCarType().equals("a.c.")) {
				car.setCharge(100);
			} else if (car.getCarType().equals("non a.c.")) {
				car.setCharge(65);
			} else if (car.getCarType().equals("safari")) {
				car.setCharge(85);

			}

		}

		this.carDao.save(car);

		return "home";

	}

	@RequestMapping(value = "customer_booking_page")
	public String customer_booking(Model model, @ModelAttribute("car") Car car) throws SQLException {

		List<Car> cars = this.carDao.getAll();
		model.addAttribute("cars", cars);

		return "customer_booking";

	}

//	------------------------Customer Registeration and Login-----------------------------------------------

	@RequestMapping("customer_registration")
	public String registration(Model model) {
		CustomerRegistration customer_reg = new CustomerRegistration();
		model.addAttribute("customer_reg", customer_reg);
		return "registration";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String save_customer(Model model, @Valid @ModelAttribute("customer_reg") CustomerRegistration customer_reg,
			BindingResult result) throws SQLException {
		if (result.hasErrors()) {
			return "registration";
		} else {

			List<String> passwords = new ArrayList();
			List<CustomerRegistration> customer1 = this.custumerDao.getAll();
			for (CustomerRegistration custmr : customer1) {

				passwords.add(custmr.getPassword());
				passwords.add(custmr.getName());

			}
			if (passwords.contains(customer_reg.getPassword()) || passwords.contains(customer_reg.getName())) {
				model.addAttribute("error", " invalid credential or already registered, try again or login!");
				return "registration";
			} else {

				this.custumerDao.save(customer_reg);
				model.addAttribute("msg", "successfully registered");
				return "home";
			}

		}
	}

	@RequestMapping("login")
	public String login(Model model) {
		CustomerLogin customer_login = new CustomerLogin();
		model.addAttribute("login", customer_login);
		return "login";
	}

	@RequestMapping(value = "loggedin", method = RequestMethod.POST)
	public String verifyCustomer(Model model, @Valid @ModelAttribute("login") CustomerLogin customer,
			BindingResult result) throws SQLException {
		if (result.hasErrors()) {

			return "login";
		} else {

			if (this.custumerDao.findByPassword(customer.getPassword()) == null) {
				model.addAttribute("error", "invalid credentials");
				return "login";
			} else {

				List<String> blocked_users = new ArrayList<String>();
				List<BlockedCustomers> users = this.blockedCustomer.getAll();
				for (BlockedCustomers block : users) {
					blocked_users.add(block.getName());

				}

				if (blocked_users.contains(customer.getName())) {
					model.addAttribute("error", "you are blocked");
					return "login";
				}

				if (this.custumerDao.findByPassword(customer.getPassword()).getPassword().equals(customer.getPassword())

						&& this.custumerDao.findByPassword(customer.getPassword()).getName()
								.equals(customer.getName())) {

					List<CustomerBooking> customer_list = this.customerBookingDao.getNameList(customer.getName());

					model.addAttribute("data", customer_list);
					model.addAttribute("msg", "logged in successfully ");

					return "customer_report";

				}

				else {
					model.addAttribute("error", "invalid credentials");
					return "login";
				}

			}

		}

	}

//	  -------------------------Booking----------------------------
	@RequestMapping("addBooking")
	public String booking(Model model) throws SQLException {

		CustomerBooking booking = new CustomerBooking();
		Car car = new Car();
		model.addAttribute("booking", booking);
		return "individual_customer_booking";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "booking", method = RequestMethod.POST)
	public String booked(Model model, @Valid @ModelAttribute("booking") CustomerBooking booking, BindingResult result)
			throws SQLException {

		if (result.hasErrors()) {

			return "individual_customer_booking";
		}

		else {

			List<CustomerBooking> customer = this.customerBookingDao.getNameList(booking.getName());
			for (CustomerBooking cust : customer) {
				System.out.println(cust.getName());
			}
			if (this.custumerDao.findByName(booking.getName()) != null) {

				List<CustomerBooking> booking1 = this.customerBookingDao.getAll();
				List<String> car_booked = new ArrayList<String>();

				List<CustomerBooking> customer_list = this.customerBookingDao.getNameList(booking.getName());
				for (CustomerBooking customer1 : customer_list) {
					car_booked.add(customer1.getCarType());
				}

				if (car_booked.contains(booking.getCarType())) {
					model.addAttribute("error", "this item already booked");
					return "individual_customer_booking";
				} else {

					// ------------Swift
					if (booking.getCar().equals("swift")) {
						if ((booking.getCarType().equals("a.c."))) {
							booking.setCharge("50");
						} else if ((booking.getCarType().equals("non a.c."))) {
							booking.setCharge("30");
						} else if ((booking.getCarType().equals("safari"))) {
							booking.setCharge("40");
						}
					}

					// ------------Thar
					if (booking.getCar().equals("thar")) {
						if (booking.getCarType().equals("a.c.")) {
							booking.setCharge("80");
						} else if (booking.getCarType().equals("non a.c.")) {
							booking.setCharge("50");

						} else if (booking.getCarType().equals("safari")) {
							booking.setCharge("55");
						}
					}
					// ------------Innova
					if (booking.getCar().equals("innova")) {

						if (booking.getCarType().equals("a.c.")) {
							booking.setCharge("70");
						} else if (booking.getCarType().equals("non a.c.")) {
							booking.setCharge("50");
						} else if (booking.getCarType().equals("safari")) {
							booking.setCharge("60");
						}
					}
					// ------------Fortuner
					else if (booking.getCar().equals("fortuner")) {
						if (booking.getCarType().equals("a.c.")) {
							booking.setCharge("100");
						} else if (booking.getCarType().equals("non a.c.")) {
							booking.setCharge("65");
						} else if (booking.getCarType().equals("safari")) {
							booking.setCharge("85");

						}

					}

					booking.setStatus("booked");
					this.customerBookingDao.save(booking);

					model.addAttribute("id", booking.getId());
					model.addAttribute("name", booking.getName());
					model.addAttribute("address", booking.getAddress());
					model.addAttribute("contact", booking.getContact());
					model.addAttribute("car", booking.getCar());
					model.addAttribute("carType", booking.getCarType());
					model.addAttribute("charge", booking.getCharge());
					model.addAttribute("payment", booking.getPayment());
					model.addAttribute("status", booking.getStatus());
					model.addAttribute("day", booking.getDay());

					return "transection_report";
				}
			} else {
				model.addAttribute("error", "you are not registered yet please");
				return "individual_customer_booking";
			}
		}

	}

	@RequestMapping("report")
	public String report(Model model) throws SQLException {

		List<CustomerBooking> reports = this.customerBookingDao.getAll();
		model.addAttribute("reports", reports);
		return "report";

	}

	@RequestMapping("transection_report")
	public String transection(Model model, @ModelAttribute("booking") CustomerBooking customer) throws SQLException {

		return "transection_report";
	}

	@RequestMapping("edit")
	public String edit(Model model, @RequestParam("id") int id, @RequestParam("carType") String carType)
			throws SQLException {

		CustomerBooking item = this.customerBookingDao.findById(id);
		System.out.println(item.getCar());

		model.addAttribute("id", item.getId());
		model.addAttribute("name", item.getName());
		model.addAttribute("address", item.getAddress());
		model.addAttribute("contact", item.getContact());
		model.addAttribute("car", item.getCar());
		model.addAttribute("charge", item.getCharge());
		model.addAttribute("carType", item.getCarType());
		model.addAttribute("payment", item.getPayment());
		model.addAttribute("status", item.getStatus());
		model.addAttribute("day", item.getDay());

		return "edit";

	}

	@RequestMapping(value = "update_product", method = RequestMethod.POST)
	public String edited(Model model, @ModelAttribute("data") CustomerBooking customer) throws SQLException {

		CustomerBooking item = this.customerBookingDao.findById(customer.getId());
		String charge = null;

		// ------------Swift
		if ("swift".equals(item.getCar())) {
			if ("a.c.".equals(customer.getCarType())) {
				customer.setCharge("60");
				model.addAttribute("charge", "60");
			} else if ("non a.c.".equals(customer.getCarType())) {
				customer.setCharge("50");
				model.addAttribute("charge", "50");
			} else if ("safari".equals(customer.getCarType())) {
				customer.setCharge("45");
				model.addAttribute("charge", "45");
			}
		}

		// ------------Thar
		else if ("thar".equals(item.getCar())) {
			if ("a.c.".equals(customer.getCarType())) {
				customer.setCharge("55");
				model.addAttribute("charge", "55");
			} else if ("non a.c.".equals(customer.getCarType())) {
				customer.setCharge("45");
				model.addAttribute("charge", "45");
			} else if ("safari".equals(customer.getCarType())) {
				customer.setCharge("80");
				model.addAttribute("charge", "80");
			}
		}
		// ------------Innova
		else if ("innova".equals(item.getCar())) {
			if ("a.c.".equals(customer.getCarType())) {
				customer.setCharge("75");
				model.addAttribute("charge", "75");
			} else if ("non a.c.".equals(customer.getCarType())) {
				charge = "57";
				model.addAttribute("charge", "57");
			} else if ("safari".equals(customer.getCarType())) {
				customer.setCharge("50");
				model.addAttribute("charge", "50");
			}
		}
		// ------------Fortuner
		else if ("fortuner".equals(item.getCar())) {
			if ("a.c.".equals(customer.getCarType())) {
				customer.setCharge("97");
				model.addAttribute("charge", "97");

			} else if ("non a.c.".equals(customer.getCarType())) {
				customer.setCharge("70");
				model.addAttribute("charge", "70");
			} else if ("safari".equals(customer.getCarType())) {
				customer.setCharge("100");
				model.addAttribute("charge", "100");
			}
		}

		model.addAttribute("id", customer.getId());
		model.addAttribute("name", customer.getName());
		model.addAttribute("address", customer.getAddress());
		model.addAttribute("contact", customer.getContact());
		model.addAttribute("car", customer.getCar());
		model.addAttribute("carType", customer.getCarType());
		model.addAttribute("day", customer.getDay());
		model.addAttribute("payment", customer.getPayment());
		model.addAttribute("status", customer.getStatus());
		this.customerBookingDao.update(customer.getName(), customer.getContact(), customer.getAddress(),
				customer.getCar(), customer.getCarType(), customer.getPayment(), customer.getStatus(), customer.getId(),
				customer.getCharge());
		return "transection_report";
	}

	@RequestMapping("customer_report")
	public String customer_report(Model model, @RequestParam("id") int id, @RequestParam("name") String name)
			throws SQLException {

		List<CustomerBooking> customer_list = this.customerBookingDao.getNameList(name);

		model.addAttribute("data", customer_list);
		model.addAttribute("msg", "paid successfully");
		return "customer_report";
	}

	@RequestMapping("delete_customer")
	public String delete_customer(Model model, @RequestParam("name") String name, @RequestParam("id") int id)
			throws SQLException {

		this.customerBookingDao.delete(id);
		List<CustomerBooking> customer_list = this.customerBookingDao.getNameList(name);

		model.addAttribute("data", customer_list);
		model.addAttribute("msg", "cancelled successfully");
		return "customer_report";
	}

//--------------------------admin------------------------------------------------	

	@RequestMapping("admin_login")
	public String admin_login(Model model) {
		CustomerLogin customer_login = new CustomerLogin();
		model.addAttribute("admin", customer_login);
		return "admin_login";

	}

	@RequestMapping(value = "admin_loggedin", method = RequestMethod.POST)
	public String verifyAdmin(Model model, @Valid @ModelAttribute("admin") CustomerLogin admin, BindingResult result)
			throws SQLException {

		if (result.hasErrors()) {

			return "admin_login";
		} else {

			if ("password".equals(admin.getPassword())

					&& "admin".equals(admin.getName())) {

				List<CustomerBooking> reports = this.customerBookingDao.getAll();
				model.addAttribute("reports", reports);
				return "report";

			} else {
				model.addAttribute("error", "to be an admin type name = admin and password=password");
				return "admin_login";
			}

		}

	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id") int id) throws SQLException {

		this.customerBookingDao.delete(id);
		List<CustomerBooking> reports = this.customerBookingDao.getAll();
		model.addAttribute("reports", reports);

		return "report";
	}

	@RequestMapping("block")
	public String Blocked(Model model, @RequestParam("id") int id, @RequestParam("name") String name)
			throws SQLException {

		String customer = this.custumerDao.findByName(name).getName();

		BlockedCustomers block = new BlockedCustomers();
		model.addAttribute("block", block);
		model.addAttribute("name", customer);

		return "block";
	}

	@RequestMapping("blocked")
	public String blocked(Model model, @ModelAttribute("block") BlockedCustomers block) throws SQLException {


			this.blockedCustomer.save(block);
			List<CustomerBooking> reports = this.customerBookingDao.getAll();
			model.addAttribute("reports", reports);
			model.addAttribute("msg", block.getName() + " Blocked");
			return "report";
		
	}

//	@RequestMapping("unblock")
//	public String unblock(Model model,@RequestParam("id") int id) throws SQLException {
//
//		this.blockedCustomer.delete(id);
//		List<CustomerBooking> reports = this.customerBookingDao.getAll();
//		model.addAttribute("reports", reports);
//		model.addAttribute("msg", "Customer Unblocked");
//		return "report";
//		
//	}

}
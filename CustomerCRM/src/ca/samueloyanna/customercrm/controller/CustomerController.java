package ca.samueloyanna.customercrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.samueloyanna.customercrm.dao.CustomerDAO;
import ca.samueloyanna.customercrm.entity.Customer;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listCustomers(Model model) {
		List <Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers", customers);
		return "listCustomers";
	}
}

package ca.samueloyanna.customercrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.samueloyanna.customercrm.dao.CustomerDAO;
import ca.samueloyanna.customercrm.entity.Customer;
import ca.samueloyanna.customercrm.service.CustomerService;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List <Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer); 
		
		return "addCustomerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
		
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer); 
		return "addCustomerForm";
		
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}

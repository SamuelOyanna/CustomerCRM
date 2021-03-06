package ca.samueloyanna.customercrm.service;

import java.util.List;

import ca.samueloyanna.customercrm.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int theId);
}

package ca.samueloyanna.customercrm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ca.samueloyanna.customercrm.entity.Customer;

public interface CustomerDAO {

	public List <Customer> getCustomers();
	
}

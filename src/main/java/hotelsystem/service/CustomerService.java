package hotelsystem.service;

import hotelsystem.model.Customer;
import hotelsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	// Autowire customer repo
    @Autowired
    private CustomerRepository customerRepository;

    // Return list of all customers
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    // Save customer object
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    // Return customer by ID
    public Customer get(Long id) {
        return customerRepository.findById(id).get();
    }
    
    // Return customer by email
    public Customer searchByEmail(String email) {
    	return customerRepository.findByEmail(email);
    }
    
    //Delete customer by ID
    public void delete(Long id) {
    	customerRepository.deleteById(id);
    }
}


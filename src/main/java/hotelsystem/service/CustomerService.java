package hotelsystem.service;

import hotelsystem.model.Customer;
import hotelsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer get(Long id) {
        return customerRepository.findById(id).get();
    }
    
//    public Customer get(String email) {
//    	return customerRepository.findByEmail(email);
//    }
    
    public void delete(Long id) {
    	customerRepository.deleteById(id);
    }
}


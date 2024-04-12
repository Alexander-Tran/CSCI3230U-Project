package hotelsystem.service;

import hotelsystem.model.Booking;
import hotelsystem.service.CustomerService;
import hotelsystem.model.Customer;
import hotelsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
	
	// Autowire booking repo
    @Autowired
    private BookingRepository bookingRepository;

    // Return list of all bookings
    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    // Save booking object
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    // Return a booking by ID
    public Booking get(Long id) {
        return bookingRepository.findById(id).get();
    }
    
    // Return a customer my email
    public Customer getCustomerByEmail(String email) {
    	CustomerService customerService = new CustomerService();
    	return customerService.searchByEmail(email);
    }
}


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

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking get(Long id) {
        return bookingRepository.findById(id).get();
    }
    
    public Customer getCustomerByEmail(String email) {
    	CustomerService customerService = new CustomerService();
    	return customerService.searchByEmail(email);
    }
}


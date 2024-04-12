package hotelsystem.service;

import hotelsystem.model.Booking;
import hotelsystem.model.Customer;
import hotelsystem.model.Room;
import hotelsystem.repository.BookingRepository;
import hotelsystem.repository.CustomerRepository;
import hotelsystem.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
	
	// Autowire booking repo
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired 
    private RoomRepository roomRepository;

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
    	for (Customer customer : customerRepository.findAll()) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public Room getRoomByRoomNumber(int roomNumber) {
    	for (Room room : roomRepository.findAll()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}


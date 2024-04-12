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

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired 
    private RoomRepository roomRepository;

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


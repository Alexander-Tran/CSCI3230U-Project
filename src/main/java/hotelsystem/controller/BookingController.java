package hotelsystem.controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotelsystem.model.Booking;
import hotelsystem.model.Customer;
import hotelsystem.model.Room;
import hotelsystem.service.BookingService;

@Controller
public class BookingController {
	
	// Autowire booking service
    @Autowired
    private BookingService bookingService;

    // Call service to display bookings page
    @GetMapping("/bookings")
    public String viewHomePage(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        model.addAttribute("listBookings", bookingService.listAll());
        return "bookings";
    }

    @PostMapping("/save-booking")
    public String saveBooking(@ModelAttribute("booking") Booking booking, Model model, @RequestParam("email") String email, @RequestParam("roomNumber") int roomNumber) {
        Customer customer = bookingService.getCustomerByEmail(email);
        Room room = bookingService.getRoomByRoomNumber(roomNumber);
        booking.setCustomer(customer);	
        booking.setRoom(room);
        bookingService.save(booking);

        return "redirect:/bookings";
    }
}   
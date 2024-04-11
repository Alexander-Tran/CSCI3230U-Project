package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hotelsystem.model.Booking;
import hotelsystem.service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String viewHomePage(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        model.addAttribute("listBookings", bookingService.listAll());
        return "bookings";
    }

    @PostMapping("/save-booking")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.save(booking);
        return "redirect:/bookings";
    }
}   
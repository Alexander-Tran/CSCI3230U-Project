package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hotelsystem.model.Booking;
import hotelsystem.service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", bookingService.listAll());
        return "bookings";
    }
}   
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
    public String saveBooking(@ModelAttribute("booking") Booking booking, Model model, @RequestParam("email") String email) {	
//    	if (bookingService.getCustomerByEmail(email) != null) {
//	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	    	try {
//				Date sdate = format.parse(booking.getStartDate());
//				Date edate = format.parse(booking.getEndDate());
//				
//				if (sdate.before(edate)) {
//					bookingService.save(booking);
//				}
//				else {
//					System.out.println("Invalid date");
//				}
//				
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				System.out.println("Date error");
//			}
//    	}
//    	else {
//    		System.out.println("Customer does not exist");
//    	}
    	
    	//Print list of customers
    	List<Customer> customers = (List<Customer>)model.getAttribute("listCustomers");
    	for (Customer customer : customers) {
    		System.out.println(customer.toString());
    	}

        return "redirect:/bookings";
    }
}   
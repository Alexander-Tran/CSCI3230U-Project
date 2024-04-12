package hotelsystem.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hotelsystem.model.Customer;
import hotelsystem.service.CustomerService;

@Controller
public class CustomerController {

	
	//Autowire customer service
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public String viewHomePage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("listCustomers", customerService.listAll());
        return "customer";
    }

    // Save a customer
    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    	//Check proper email
    	Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    	Matcher email_matcher = email_regex.matcher(customer.getEmail());
    	
    	//Check proper phone
    	Pattern phone_regex = Pattern.compile("^\\d{10}$");
    	Matcher phone_matcher = phone_regex.matcher(customer.getPhoneNumber().toString());
    	
    	if (email_matcher.matches() && phone_matcher.matches()) {
    		customerService.save(customer);
    	}
    	else {
    		System.out.println("Error validating information");
    	}
    	
        return "redirect:/customers";
    }
    
    // Remove a customer by ID
    @PostMapping("/remove-customer")
    public String deleteCustomer(Long id) {
    	customerService.delete(id);
    	return "redirect:/customers";
    }
}
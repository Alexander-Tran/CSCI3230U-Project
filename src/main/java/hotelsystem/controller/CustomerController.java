package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hotelsystem.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", customerService.listAll());
        return "customer";
    }
}
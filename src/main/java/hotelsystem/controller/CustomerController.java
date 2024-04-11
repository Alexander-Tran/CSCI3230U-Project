package hotelsystem.controller;

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

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public String viewHomePage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("listCustomers", customerService.listAll());
        return "customer";
    }

    @GetMapping("/customers-new")
    public String showNewCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
}
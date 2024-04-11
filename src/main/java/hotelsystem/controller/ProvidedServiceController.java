package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hotelsystem.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;
    
    @GetMapping("/services")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", providedServiceService.listAll());
        return "service";
    }

}
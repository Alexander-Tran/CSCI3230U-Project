package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hotelsystem.model.ProvidedServices;
import hotelsystem.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;
    
    @GetMapping("/services")
    public String viewHomePage(Model model) {
        model.addAttribute("listProvidedServices", providedServiceService.listAll());
        return "service";
    }

    @GetMapping("/services-new")
    public String showNewProvidedServiceForm(Model model) {
        ProvidedServices providedService = new ProvidedServices();
        model.addAttribute("providedService", providedService);
        return "service";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("providedService") ProvidedServices providedService) {
        providedServiceService.save(providedService);
        return "redirect:/rooms";
    }
}
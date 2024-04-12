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
	// Autowire services service
    @Autowired
    private ProvidedServiceService providedServiceService;
    
    // Load services page
    @GetMapping("/services")
    public String viewHomePage(Model model) {
        ProvidedServices providedService = new ProvidedServices();
        model.addAttribute("providedService", providedService);
        model.addAttribute("listProvidedServices", providedServiceService.listAll());
        return "service";
    }

    // Save a service
    @PostMapping("/save-service")
    public String saveProvidedService(@ModelAttribute("providedService") ProvidedServices providedService) {
        providedServiceService.save(providedService);
        return "redirect:/services";
    }
    
    // Remove a service by ID
    @PostMapping("/remove-service")
    public String removeService(Long id) {
    	providedServiceService.delete(id);
    	return "redirect:/services";
    }
}
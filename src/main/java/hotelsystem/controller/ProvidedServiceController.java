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
        ProvidedServices providedService = new ProvidedServices();
        model.addAttribute("providedService", providedService);
        model.addAttribute("listProvidedServices", providedServiceService.listAll());
        return "service";
    }

    @PostMapping("/save-service")
    public String saveProvidedService(@ModelAttribute("providedService") ProvidedServices providedService) {
        providedServiceService.save(providedService);
        return "redirect:/services";
    }
}
package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hotelsystem.service.RoomService;

@Controller
class RoomController {

    @Autowired
    private RoomService roomService;
    
    @GetMapping("/rooms")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", roomService.listAll());
        return "rooms";
    }
}
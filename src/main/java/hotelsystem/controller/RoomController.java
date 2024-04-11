package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hotelsystem.model.Room;
import hotelsystem.service.RoomService;

@Controller
class RoomController {

    @Autowired
    private RoomService roomService;
    
    @GetMapping("/rooms")
    public String viewHomePage(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        model.addAttribute("listRooms", roomService.listAll());
        return "rooms";
    }

    @PostMapping("/save-room")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.save(room);
        return "redirect:/rooms";
    }
}
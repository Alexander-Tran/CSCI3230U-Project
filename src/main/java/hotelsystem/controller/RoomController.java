package hotelsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import hotelsystem.model.Room;
import hotelsystem.service.RoomService;
import java.util.List;

@Controller
class RoomController {

	// Autowire room service
    @Autowired
    private RoomService roomService;
    
    // Load rooms page
    @GetMapping("/rooms")
    public String viewHomePage(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        model.addAttribute("listRooms", roomService.listAll());
        return "rooms";
    }

    // Save a room
    @PostMapping("/save-room")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.save(room);
        return "redirect:/rooms";
    }
    
    // Remove a room by ID
    @PostMapping("/remove-room")
    public String deleteRoom(Long id) {
        roomService.delete(id);
        return "redirect:/rooms";
    }
    
    // Search room by type
    @GetMapping("/search")
    public String searchRoom(Model model, @RequestParam String type) {
        List<Room> returnedRooms = roomService.searchByType(type);
        for (Room room : returnedRooms) {
            System.out.println(room.toString());
        }
        model.addAttribute("searchRooms", returnedRooms);
        return "redirect:/rooms";
    }
}
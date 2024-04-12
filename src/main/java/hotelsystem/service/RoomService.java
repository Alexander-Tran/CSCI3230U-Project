package hotelsystem.service;

import hotelsystem.model.Room;
import hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

	// Autowire room repo
    @Autowired
    private RoomRepository roomRepository;

    // Return list of all rooms
    public List<Room> listAll() {
        return roomRepository.findAll();
    }

    // Save room object
    public void save(Room room) {
        roomRepository.save(room);
    }

    // Return room by ID
    public Room get(Long id) {
        return roomRepository.findById(id).get();
    }

    // Delete room by ID
    public void delete(Long id) {
    	roomRepository.deleteById(id);
    }
    
    // List room by type
    public List<Room> searchByType(String type) {
    	return roomRepository.findByType(type);
    }
}


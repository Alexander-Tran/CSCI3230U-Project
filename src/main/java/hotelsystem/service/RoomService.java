package hotelsystem.service;

import hotelsystem.model.Room;
import hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> listAll() {
        return roomRepository.findAll();
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

    public Room get(Long id) {
        return roomRepository.findById(id).get();
    }
}


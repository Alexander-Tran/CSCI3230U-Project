package hotelsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hotelsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query("select r from Room r where upper(r.type) like concat('%', upper(:type), '%')")
	List<Room> findByType(@Param("type") String type);
}
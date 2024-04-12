package hotelsystem.repository;

import hotelsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

// Create booking repo
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
package hotelsystem.repository;

import hotelsystem.model.ProvidedServices;
import org.springframework.data.jpa.repository.JpaRepository;

// Create services repo
public interface ServiceRepository extends JpaRepository<ProvidedServices, Long> {
}
package hotelsystem.repository;

import hotelsystem.model.ProvidedServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ProvidedServices, Long> {
}
package hotelsystem.repository;

import hotelsystem.model.Customer;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// Create customer repo
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// JPA query to find customer by email
	@Query("select c from Customer c where upper(c.email) like concat('%', upper(:email), '%')")
	Customer findByEmail(@Param("email") String email);
} 
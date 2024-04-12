package hotelsystem.repository;

import hotelsystem.model.Customer;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select c from Customer c where upper(c.email) like concat('%', upper(:email), '%')")
	List<Customer> findByEmail(@Param("email") String email);
} 
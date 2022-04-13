package dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

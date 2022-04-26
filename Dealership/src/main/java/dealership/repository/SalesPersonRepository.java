package dealership.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dealership.beans.SalesPerson;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

	Optional<SalesPerson>findByVehicleName(String vehicleName);
	List<SalesPerson> getAllSales();
}

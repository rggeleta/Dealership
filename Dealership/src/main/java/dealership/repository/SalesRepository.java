package dealership.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.beans.Sales;




public interface SalesRepository extends JpaRepository<Sales, Long> {

	Optional<Sales> findAllByVehicleName(String vehicleName);

	List<Sales> findAllByVehicleNameIgnoreCase(String vehicleName);
	
	Optional<Sales>findByVehicleName(String vehicleName);
	


}

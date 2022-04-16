package dealership.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import dealership.beans.SalesPerson;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

	Optional<SalesPerson>findByVehicleName(String vehicleName);
}

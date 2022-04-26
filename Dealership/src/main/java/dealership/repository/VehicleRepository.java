package dealership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.beans.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	List<Vehicle> findAllByMake(String make);
	
	List<Vehicle> findAllByMakeIgnoreCase(String make);
	
   
}

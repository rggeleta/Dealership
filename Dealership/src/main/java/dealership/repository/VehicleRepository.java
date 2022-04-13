package dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.beans.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}

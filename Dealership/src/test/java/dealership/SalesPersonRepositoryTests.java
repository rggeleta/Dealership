package dealership;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import dealership.beans.SalesPerson;
import dealership.repository.SalesPersonRepository;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest  // this annotation will test the repository entities
public class SalesPersonRepositoryTests {
	
	@Autowired 
	private SalesPersonRepository salesPersonRepository;
	
	// JUnite Tests
	// save sales if the id is greater than 0
	
	@Test   //this annotation to make the test as Junit test
	@Order(1)   //this testcase will be excuted first
	@Rollback(value = false)
	public void saveSalesTest() {
		
		SalesPerson salesPerson = SalesPerson.builder()
				.firstName("Roman")
				.lastName("Geleta")
				.vehicleName("Toyota")
				.build();   //call build method,  this will create the salesperson object
	
		salesPersonRepository.save(salesPerson);  // this will save the sales person object to the database
	
		Assertions.assertThat(salesPerson.getId()).isGreaterThan(0); //this will validate that the sales person id is greater than 0
	// this test should fail
	}

	// findById test this test will pass is the id is equal to 1
	@Test
	@Order(2)
	public void getSalesTest() {
		
		SalesPerson salesPerson = salesPersonRepository.findById(1L).get();
		Assertions.assertThat(salesPerson.getId()).isEqualTo(1L);
		
	}
  
//get list is list is greater than 0
	@Test
	@Order(3)
	public void getListOfSalesTest() {
		
		List<SalesPerson> salesPerson = salesPersonRepository.findAll();
		Assertions.assertThat(salesPerson.size()).isGreaterThan(0);
		
	}
	 //update method
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateSalesTest() {
		
		SalesPerson salesPerson = salesPersonRepository.findById(1L).get();
		
		salesPerson.setVehicleName("Nissan");  //this will update the vehicle name to Nissan
		SalesPerson salesUpdated =salesPersonRepository.save(salesPerson); // and it will save the updated vehicle name
		Assertions.assertThat(salesUpdated.getVehicleName()).isEqualTo("Nissan");
		
	}
	
	//junit test for delete operation
  
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteSales() {
		SalesPerson salesPerson = salesPersonRepository.findById(1L).get();
		salesPersonRepository.delete(salesPerson);  // this will delete the salesperson entity from the database
	   
		SalesPerson sales1 = null;
		Optional<SalesPerson> OptionalSalesPerson = salesPersonRepository.findByVehicleName("Toyota");
		if(OptionalSalesPerson.isPresent()) {
			sales1 = OptionalSalesPerson.get();
		}
		Assertions.assertThat(sales1).isNull();
	}

}

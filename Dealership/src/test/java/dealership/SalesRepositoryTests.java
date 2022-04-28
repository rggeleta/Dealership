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

import dealership.beans.Sales;
import dealership.repository.SalesRepository;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest  // this annotation will test the repository entities
public class SalesRepositoryTests {

	@Autowired 
	private SalesRepository salesRepository;



	// JUnite Tests
	// save sales if the id is greater than 0

	@Test   //this annotation to make the test as Junit test
	@Order(1)   //this testcase will be excuted first
	@Rollback(value = false)
	public void saveSalesTest() {

		Sales sales = Sales.builder()
				.firstName("Roman")
				.lastName("Geleta")
				.vehicleName("Toyota")
				.build();   //call build method,  this will create the salesperson object

		salesRepository.save(sales);  // this will save the sales person object to the database

		Assertions.assertThat(sales.getId()).isGreaterThan(0); //this will validate that the sales person id is greater than 0
	// this test should fail
	}



	// findById test this test will pass is the id is equal to 1
	@Test
	@Order(2)
	public void getSalesTest() {

		Sales sales = salesRepository.findById(1L).get();
		Assertions.assertThat(sales.getId()).isEqualTo(1L);

	}


	//get list is list is greater than 0
		@Test
		@Order(3)
		public void getListOfSalesTest() {

			List<Sales> sales = salesRepository.findAll();
			Assertions.assertThat(sales.size()).isGreaterThan(0);

		}



	 //update method
		@Test
		@Order(4)
		@Rollback(value = false)
		public void updateSalesTest() {

			Sales sales = salesRepository.findById(1L).get();

			sales.setVehicleName("Nissan");  //this will update the vehicle name to Nissan
			Sales salesUpdated =salesRepository.save(sales); // and it will save the updated vehicle name
			Assertions.assertThat(salesUpdated.getVehicleName()).isEqualTo("Nissan");

		}


	//junit test for delete operation

		@Test
		@Order(5)
		@Rollback(value = false)
		public void deleteSales() {
			Sales sales = salesRepository.findById(1L).get();
			salesRepository.delete(sales);  // this will delete the salesperson entity from the database

			Sales sales1 = null;
			Optional<Sales> OptionalSales = salesRepository.findByVehicleName("Toyota");
			if(OptionalSales.isPresent()) {
				sales1 = OptionalSales.get();
			}
			Assertions.assertThat(sales1).isNull();
		}
} 

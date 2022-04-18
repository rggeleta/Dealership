/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Apr 18, 2022
 */
package dealership;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dealership.beans.Customer;

class CustomerClassTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link dealership.beans.Customer#Customer(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCustomerStringString() {
		Customer test = new Customer("Ryan", "Juelsgaard");
		assertEquals("Ryan", test.getFirstName());
		assertEquals("Juelsgaard", test.getLastName());
	}

	/**
	 * Test method for {@link dealership.beans.Customer#Customer(long, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCustomerLongStringString() {
		Customer test = new Customer(1,"Ryan", "Juelsgaard");
		assertEquals(1, test.getId());
		assertEquals("Ryan", test.getFirstName());
		assertEquals("Juelsgaard", test.getLastName());
	}

	/**
	 * Test method for {@link dealership.beans.Customer#setFirstName(java.lang.String)}.
	 */
	@Test
	void testSetFirstName() {
		Customer test = new Customer("Ryan", "Juelsgaard");
		test.setFirstName("Pedro");
		assertEquals("Pedro", test.getFirstName());
	}

	/**
	 * Test method for {@link dealership.beans.Customer#setLastName(java.lang.String)}.
	 */
	@Test
	void testSetLastName() {
		Customer test = new Customer("Ryan", "Juelsgaard");
		test.setLastName("Lee");
		assertEquals("Lee", test.getLastName());
	}

}

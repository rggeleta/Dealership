/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Apr 18, 2022
 */
package dealership;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dealership.beans.Vehicle;

class VehicleClassTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}


	/**
	 * Test method for {@link dealership.beans.Vehicle#setMake(String)}.
	 */
	@Test
	void testSetMake() {
		Vehicle test = new Vehicle();
		test.setMake("Ford");
		Assertions.assertEquals("Ford", test.getMake());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setModel(String)}.
	 */
	@Test
	void testSetModel() {
		Vehicle test = new Vehicle();
		test.setModel("Acura");
		Assertions.assertEquals("Acura", test.getModel());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setColor(String)}.
	 */
	@Test
	void testSetColor() {
		Vehicle test = new Vehicle();
		test.setColor("Blue");
		Assertions.assertEquals("Blue", test.getColor());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setPrice(float)}.
	 */
	@Test
	void testSetPrice() {
		Vehicle test = new Vehicle();
		test.setPrice(24000.99);
		Assertions.assertEquals(24000.99, test.getPrice());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setSold(boolean)}.
	 */
	@Test
	void testSetSold() {
		Vehicle test = new Vehicle();
		test.setSold(true);
		Assertions.assertTrue(test.isSold());
	}

}

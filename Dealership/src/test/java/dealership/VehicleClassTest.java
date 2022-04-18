/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Apr 18, 2022
 */
package dealership;

import static org.junit.jupiter.api.Assertions.*;

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
	 * Test Method for a No Args Constructor
	 */
	@Test
	void testVehicleNoArgs() {
		Vehicle test = new Vehicle();
		assertEquals(0, test.getId());
		assertNull(test.getMake());
		assertNull(test.getModel());
		assertNull(test.getColor());
		assertEquals(0.0, test.getPrice());
		assertFalse(test.isSold());
	}
	
	/**
	 * Test Method for an All Args Constructor
	 */
	
	@Test
	void testVehicleAllArgs() {
		Vehicle test = new Vehicle(1, "Ford", "Focus", "Black", 24000.99, false);
		assertEquals(1, test.getId());
		assertEquals("Ford",test.getMake());
		assertEquals("Focus", test.getModel());
		assertEquals("Black", test.getColor());
		assertEquals(24000.99, test.getPrice());
		assertFalse(test.isSold());
	}
	/**
	 * Test method for {@link dealership.beans.Vehicle#setMake(String)}.
	 */
	@Test
	void testSetMake() {
		Vehicle test = new Vehicle();
		test.setMake("Ford");
		assertEquals("Ford", test.getMake());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setModel(String)}.
	 */
	@Test
	void testSetModel() {
		Vehicle test = new Vehicle();
		test.setModel("Acura");
		assertEquals("Acura", test.getModel());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setColor(String)}.
	 */
	@Test
	void testSetColor() {
		Vehicle test = new Vehicle();
		test.setColor("Blue");
		assertEquals("Blue", test.getColor());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setPrice(float)}.
	 */
	@Test
	void testSetPrice() {
		Vehicle test = new Vehicle();
		test.setPrice(24000.99);
		assertEquals(24000.99, test.getPrice());
	}

	/**
	 * Test method for {@link dealership.beans.Vehicle#setSold(boolean)}.
	 */
	@Test
	void testSetSold() {
		Vehicle test = new Vehicle();
		test.setSold(true);
		assertTrue(test.isSold());
	}

}

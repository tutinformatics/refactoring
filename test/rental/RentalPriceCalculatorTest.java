package rental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalPriceCalculatorTest {

	private RentalPriceCalculator rentalPriceCalculator;
	
	@Before
	public void beforeEachTest() {
		rentalPriceCalculator = new RentalPriceCalculator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCantRentUnderAge() {
		rentalPriceCalculator.calculatePrice(17, 1, 1, false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCanRentIs18YearsOld() {
		double price = rentalPriceCalculator.calculatePrice(18, 1, 1, false, false);
		assertEquals(23.4, price, 0.1);
	}
}

package rental;

import org.junit.Before;
import org.junit.Test;

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
		rentalPriceCalculator.calculatePrice(18, 1, 1, false, false);
	}
}

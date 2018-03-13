package rental;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
    private RentalPriceCalculator calculator;
	
	@Before
	public void beforeEachTest() {
		calculator = new RentalPriceCalculator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCannotRentYoung() {
		calculator.calculateRentalPrice(17, 5, 3, false, true);
	}

	@Test
    public void testCanRent() {
	    assert(18.0 == calculator.calculateRentalPrice(18, 4, 1, false, false));
    }
}

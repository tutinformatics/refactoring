package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	
	private RentalPriceCalculator calculator;
	
	@Before
	public void beforeEachTest() {
		calculator= new RentalPriceCalculator();
	}

	@Test
	public void maxRentalPrice() {
		assertEquals(1000, calculator.calculateRentalPrice(25, 5, false, true, 2000, 3), 0.001);
	}
}

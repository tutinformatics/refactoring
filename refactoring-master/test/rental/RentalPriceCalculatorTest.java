package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	private RentalPriceCalculator calculator;
	@Before
	public void beforeEachTest() {
		// this method is called before each test
		calculator = new RentalPriceCalculator();
	}

	@Test
	public void priceNormalFor3YearsOfExperience() {
		assertEquals(100,
				calculator
				.adaptPriceOnDriversPeriod(3, 100), 0.0001);
		
		
	}
	@Test
	public void priceNormalFor11YearsOfExperience() {
		assertEquals(100,
				calculator
				.adaptPriceOnDriversPeriod(11, 100), 0.0001);
		
		
	}
	@Test
	public void priceHigherForUnexperiencedDriver() {
		assertEquals(130,
				calculator
				.adaptPriceOnDriversPeriod(1, 100), 0.0001);
		
		
	}


}

package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	
	private RentalPriceCalculator calculator;
	
	@Before
	public void beforeEachTest() {
		calculator = new RentalPriceCalculator();
	}

	@Test
	public void testCheckIfApplicable() {
//		assertEquals()
	}
	
	@Test
	public void testCheckLicence() {
		assertEquals(1.3, calculator.checkLicense(2, 1.0), 0.00001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCheckLicence2() {
		assertEquals(1.3, calculator.checkLicense(1, 1.0), 0.00001);
	}
}

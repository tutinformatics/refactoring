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
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void priceHigherForUnexperiencedDriver() {
		assertEquals(130, calculator.checkLicense(2, 100), 0.0001);
	}
	
	@Test
	public void priceNormalFor3YearsOfExperience() {
		assertEquals(100, calculator.checkLicense(3, 100), 0.0001);
	}
	
	@Test
	public void priceNormalFor13YearsOfExperience() {
		assertEquals(100, calculator.checkLicense(13, 100), 0.0001);
	}
	
	@Test
	public void isAge20LegalForFirstCarClass() {
		assertEquals(true, calculator.isLegalToRent(20, 2, 1));
	}
	
	@Test
	public void isAge20LegalForThirdCarClass() {
		assertEquals(false, calculator.isLegalToRent(20, 2, 3));
	}
	
	@Test
	public void isPriceHigherForAge25orLessWhenClass4() {
		assertEquals(200, calculator.adaptPriceByAge(100, 25, 4, true), 0.0001);
	}
}

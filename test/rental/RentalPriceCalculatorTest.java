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
	public void priceRemainsTheSameFor5YearsOfExperience() {
		assertEquals(5, calculator.howManyYearsLicenceOwned(5), 0.00001);
	}
	
	@Test
	public void priceRemainsTheSameFor1YearsOfExperience() {
		assertEquals(1, calculator.howManyYearsLicenceOwned(1), 0.00001);
	}
	
	@Test
	public void priceRemainsTheSameFor3YearsOfExperience() {
		assertEquals(3, calculator.howManyYearsLicenceOwned(3), 0.00001);
	}
	
	@Test
	public void highSeason() {
		assertTrue(calculator.isHighSeason(true));
	}
	
	@Test
	public void accidentsHad() {
		assertTrue(calculator.ifHadAccidentLastYear(true));
	}
	
	
}

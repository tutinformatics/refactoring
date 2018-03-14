package rental;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	private RentalPriceCalculator rentalPriceCalculator;

	@Before
	public void beforeEachTest() {
		this.rentalPriceCalculator = new RentalPriceCalculator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatUnderageDriverCannotDrive() {
		rentalPriceCalculator.calculatePrice(16, 0, 1, false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatDriverEdgeCaseWithLegalCar() {
		double price = rentalPriceCalculator.calculatePrice(18, 1, 1, false, false);
		assertEquals( 18.0, price, 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatAdultCanDriveACar() {
		double price = rentalPriceCalculator.calculatePrice(30, 5, 2, false, false);
		assertEquals(30.0, price, 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatYouthCanRentOnlyFirstClass() {
		double price = rentalPriceCalculator.calculatePrice(20, 5, 2, false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatPriceDoesNotExceedMax() {
		double price = rentalPriceCalculator.calculatePrice(25, 5, 2, true, true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatPriceIsDoubleWhenItISHighSeason() {
		double price = rentalPriceCalculator.calculatePrice(24, 5, 2, false, true);
		assertEquals(36.0, price, 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatRentIsPermittedWhenLicenceISLessThan1YearOld() {
		double price = rentalPriceCalculator.calculatePrice(24, 0, 2, false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatPriceIsHigherWhenDriverHasCausedAccidents() {
		double price = rentalPriceCalculator.calculatePrice(24, 5, 2, true, false);
		assertEquals(39.0, price, 0.01);
	}
}

package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	RentalPriceCalculator calculator = new RentalPriceCalculator();
	
	@Before
	public void beforeEachTest() {
		// this method is called before each test
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnder18NotAllowed() {
		RentalRequest request = new RentalRequest(
			17, 10, VehicleClass.FIRST_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test(expected=InvalidRequestException.class)
	public void testLicenseNotHeldLongEnough() {
		RentalRequest request = new RentalRequest(
				17, 0, VehicleClass.FIRST_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnder21SecondClassNotAllowed() {
		RentalRequest request = new RentalRequest(
				19, 0, VehicleClass.SECOND_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnder21ThirdClassNotAllowed() {
		RentalRequest request = new RentalRequest(
				19, 0, VehicleClass.THIRD_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnder21FourthClassNotAllowed() {
		RentalRequest request = new RentalRequest(
				19, 0, VehicleClass.FOURTH_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnder21FifthClassNotAllowed() {
		RentalRequest request = new RentalRequest(
				19, 0, VehicleClass.FIFTH_CLASS, false, false, false);
		calculator.validateRequest(request);
	}

	@Test
	public void testPriceRemainsSameFor5YearsOfExperience() {
		RentalRequest request = new RentalRequest(
			19, 5, VehicleClass.FIRST_CLASS, false, false, false);
		assertEquals(100, calculator.adjustEstimateForLicenseHeld(100, request), 0.0001);
	}

	@Test
	public void testInitialPriceIsDriverAge() {
		RentalRequest request = new RentalRequest(
				19, 5, VehicleClass.FIRST_CLASS, false, false, false);
		assertEquals(19, calculator.getInitialEstimate(request), 0.0001);
	}

	@Test
	public void testMaxPriceIs1000() {
		assertEquals(1000.0, calculator.getPriceFromEstimate(1500.0), 0.0001);
	}

	@Test
	public void testPriceLessThan1000() {
		assertEquals(900.0, calculator.getPriceFromEstimate(900.0), 0.0001);
	}
}
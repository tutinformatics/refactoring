package rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {

	private RentalPriceCalculator calculator;
	@Before
	public void beforeEachTest() {
		this.calculator = new RentalPriceCalculator();
	}

	@Test
	public  void canRentCarLegalAge() {
		calculator.isEligibleToRent(18,1,2);
	}
	@Test
	public void cantRentCarIllegalAge() {
		calculator.isEligibleToRent(16, 1, 1);
	}
	@Test
	public void calculatorGivesCorrectPrice(){
		Assert.assertEquals(calculator.getRentalPrice(24,2,3,true,
				true),46.2,0);
	}
	@Test

}

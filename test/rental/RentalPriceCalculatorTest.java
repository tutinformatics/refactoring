package rental;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {

	private RentalPriceCalculator calculator;

	@Before
	public void beforeEachTest() {
		calculator = new RentalPriceCalculator();
	}

	@Test
	public void ifPriceGreaterThanMaxReturnMax() {
		assertEquals(1000, calculator.price(29, 2, 5, true, false), 0.1);
	}

    @Test(expected = UnsupportedOperationException.class)
    public void youngerThan18Test() {
        calculator.price(1, 1, 1, true, true);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void illegalDriverClazzTest() {
        calculator.price(21, 2, 2, false, true);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkNumberOfFullYearsTest() {
        calculator.price(1, 0, 1, true, false);
    }
}

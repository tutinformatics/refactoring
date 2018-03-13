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

    @Test(expected = IllegalArgumentException.class)
    public void testTooYoung() {
        calculator.calculateRentalPrice(17, 1, 3, false, false);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnder22CannotRentClass2Vehicles() {
        calculator.calculateRentalPrice(21, 1, 2, false, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotRentWithLicenseAgeUnder1() {
        calculator.calculateRentalPrice(25, 0, 3, false, false);
    }

    @Test
    public void testCalculatableRentalPrice() {
        assertEquals(33.0,
                new RentalPriceCalculator().calculateRentalPrice(33, 10, 5,true,false),
                0.001);
    }
}

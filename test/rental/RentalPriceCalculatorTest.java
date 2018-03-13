package rental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RentalPriceCalculatorTest {

    private RentalPriceCalculator calculator;

    @Before
    public void setUp() {
        this.calculator = new RentalPriceCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void below18CannotRentAFuckingCar() {
        calculator.checkAgeOfDriver(15, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void below21CannotRentAFuckingCarOfClassHigherThan1() {
        calculator.checkAgeOfDriver(20, 2);
    }

    @Test
    public void normalPersonCanRentAFuckingCarOfAnyLevel() {
        calculator.checkAgeOfDriver(25,  3);
    }

    @Test
    public void driverExperienceIsTooFuckingLow() {
        calculator.checkDrivingExperience(1);
    }

    @Test
    public void maxRentalPriceIsFucking1000() {
        calculator.setRentalPrice(1212121212.5);
        assertEquals(calculator.getFinalRentalPrice(), 1000.00, 0);
    }

    @Test
    public void minPriceEqualsPersonAge() {
        assertEquals(calculator.price(26, 4, 2, false,
                false), 26, 0);
    }

    @Test
    public void carClassOf4And5AreTwoTimesMoreExpensive() {
        assertEquals(calculator.price(24, 4, 4, false,
                false), 48, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooUnExperiencedDriver() {
        calculator.price(27, 0, 2, false, false);
    }

    @Test
    public void drivingExperienceLessThan3Years() {
        assertEquals(calculator.price(26, 2, 2, false,
                false), 26 * 1.3, 0);
    }

    @Test
    public void accidentsMoreThan1() {
        assertEquals(calculator.price(26, 4, 2, true,
                false), 26 + 15, 0);
    }
}
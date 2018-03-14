package rental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalPriceCalculatorTest {

    private static final double EPSILON = 10e-4;
    private CarRentalClient client;
    private RentalCar car;
    private RentalPriceCalculator calc;
	
	@Before
	public void beforeEachTest() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnderageClient() throws Exception {
	    client = new CarRentalClient(17, 366, false);
	    car = new RentalCar(1);

	    calc = new RentalPriceCalculator(client, car);
        calc.calculate(false);
	}

    @Test(expected = UnsupportedOperationException.class)
    public void testClientOfAge18HighClassCar() throws Exception {
        this.client = new CarRentalClient(18, 366, false);
        this.car = new RentalCar(2);

        calc = new RentalPriceCalculator(client, car);
        calc.calculate(false);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testClientOfAge21HighClassCar() throws Exception {
        this.client = new CarRentalClient(21, 366, false);
        this.car = new RentalCar(2);

        calc = new RentalPriceCalculator(client, car);
        calc.calculate(false);
    }

    @Test
    public void testClientOfAge50HighClassCarB() throws Exception {
        this.client = new CarRentalClient(50, 366, false);
        this.car = new RentalCar(2);

        calc = new RentalPriceCalculator(client, car);
        calc.calculate(false);
    }

    @Test
    public void testClientOfAge25HighClassCarHighSeason() throws Exception {
        this.client = new CarRentalClient(25, 366 * 3, false);
        this.car = new RentalCar(4);

        calc = new RentalPriceCalculator(client, car);
        assertEquals(25 + 12.5, calc.calculate(true), EPSILON);
    }

    @Test
    public void testClientOfAge25HighClassCarNotHighSeason() throws Exception {
        this.client = new CarRentalClient(25, 366 * 3, false);
        this.car = new RentalCar(5);

        calc = new RentalPriceCalculator(client, car);
        assertEquals(25, calc.calculate(false), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClientHoldingLicenseUnderYear() throws Exception {
        this.client = new CarRentalClient(50, 200, false);
        this.car = new RentalCar(1);

        calc = new RentalPriceCalculator(client, car);
        calc.calculate(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaximumPrice() throws Exception {
        this.client = new CarRentalClient(9999 /* Hmm... */, 200, false);
        this.car = new RentalCar(1);

        calc = new RentalPriceCalculator(client, car);
        assertEquals(1000, calc.calculate(false), EPSILON);
    }

    @Test
    public void testClientHoldingLicenseUnderThreeYears() throws Exception {
        this.client = new CarRentalClient(30, 700, false);
        this.car = new RentalCar(1);

        calc = new RentalPriceCalculator(client, car);
        assertEquals(30 + 9, calc.calculate(false), EPSILON);
    }

    @Test
    public void testClientOfAge29HasCausedAccidents() throws Exception {
        this.client = new CarRentalClient(29, 2000, true);
        this.car = new RentalCar(1);

        calc = new RentalPriceCalculator(client, car);
        assertEquals(29 + 15, calc.calculate(false), EPSILON);
    }
}

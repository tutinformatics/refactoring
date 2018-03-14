package rental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
    private RentalPriceCalculator rentalPriceCalculator;
	
	@Before
	public void beforeEachTest() {
		rentalPriceCalculator = new RentalPriceCalculator();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgeLess18() {
		rentalPriceCalculator.getRentalPrice(16, 0, 0, false, false, false);
	}

    @Test(expected = UnsupportedOperationException.class)
    public void testAgeLess21AndCarClassTypeBigger1() {
        rentalPriceCalculator.getRentalPrice(20, 2, 3, false, false, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDriveAgeLess1() {
        rentalPriceCalculator.getRentalPrice(20, 0, 0, false, false, false);
    }

    @Test
    public void testPriceWithoutRestricts() {
	    assertEquals(26.0, rentalPriceCalculator.getRentalPrice(
	            26, 6, 2, false, false, false
        ), 0.01);
    }
}

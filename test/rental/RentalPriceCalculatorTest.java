package rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	RentalPriceCalculator test = new RentalPriceCalculator();
	
	@Before
	public void beforeEachTest() {
		// this method is called before each test
	}

	@Test
	public void basicTest() {
		Assert.assertEquals(test.quotePrice(27,5,5,false,false),27,0.0001);
	}

	@Test
	public void highSeasonTest() {
		Assert.assertEquals(test.quotePrice(24,4,5,false,true),36,0.0001);
	}

	@Test
	public void youngDriverTest() {
		Assert.assertEquals(test.quotePrice(30,1,5,false,true),39,0.0001);
	}

	@Test
	public void maxRentPrice() {
		Assert.assertTrue(test.quotePrice(1005,1,5,true,true) <= 1000.00);
	}

	@Test
	public void accidentTest() {
		Assert.assertEquals(test.quotePrice(25,5,5,true,false),40,0.0001);
	}

	@Test
	public void testDriverAge17() {
		try {
			test.quotePrice(17,2,3,true, true);
			Assert.fail( "Driver is not underage" );
		} catch (IllegalArgumentException expectedException) {
		}
	}

	@Test
	public void testDriverAge20() {
		try {
			test.quotePrice(20, 2, 3,  true, true);
			Assert.fail("Driver age not between 18-21");
		} catch (UnsupportedOperationException expectedException) {
		}
	}

	@Test
	public void newDriverTest() {
		try {
			test.quotePrice(29, 0, 3,  true, true);
			Assert.fail("Not a new driver (has license for at least a year)");
		} catch (IllegalArgumentException expectedException) {
		}
	}





}

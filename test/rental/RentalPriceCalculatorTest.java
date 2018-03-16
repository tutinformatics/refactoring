package rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {
	
	@Before
	public void beforeEachTest() {
		this.rentalPriceCalculator = new RentalPriceCalculator();
	}
	
	private RentalPriceCalculator rentalPriceCalculator;
	

	@Test (expected = IllegalArgumentException.class)
	public void isAllowedToRentTest() {
		rentalPriceCalculator.calc_rental_price(16, 0 ,1,false,false);
		rentalPriceCalculator.calc_rental_price(22, 0 ,1,false,false);
	}
	
	@Test
	public void highSeasonPricingTest() {
		double price = rentalPriceCalculator.calc_rental_price(24,12,20,false,true);
		Assert.assertEquals(48, price, 0.1);
	}
	
	@Test
	public void unExperiencedRenterTest() {
		double price = rentalPriceCalculator.calc_rental_price(20, 2, 2, false, false);
		Assert.assertEquals(26,price, 0.1);
	}
	
	@Test
	public void maximumPriceCalcTest() {
		double price = rentalPriceCalculator.calc_rental_price(1210, 100 ,1,false,false);
		Assert.assertEquals(1000, price, 0.1);
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void unexperiencedDriverCarTest() {
		rentalPriceCalculator.calc_rental_price(20, 2 ,3,false,false);
	}
	
	@Test
	public void riskyRentTest() {
		double price = rentalPriceCalculator.calc_rental_price(24, 3 ,1,true,false);
		Assert.assertEquals(39,price,0.1);
	}
}

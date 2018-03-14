package rental;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static rental.RentalPriceCalculator.*;

public class RentalPriceCalculatorTest {
	private static final double DELTA = 1e-15;
	private int age;
	private int licence;
	private int carClass;
	private boolean acc;
	private boolean season;
	boolean thrown;
	@Before
	public void beforeEachTest() {
		age = 23;
		licence = 5;
		carClass = 1;
		acc = false;
		season = false;
		thrown = false;
	}
	@Test
	public void priceTest() {
		double price = price(age,licence,carClass,acc,season);
		Assert.assertEquals(23,price,DELTA);
	}

	@Test
	public void calculatePriceTest() {
		double price = calculatePrice(age,licence,carClass,acc,season);
		Assert.assertEquals(23,price, DELTA);
		age =79;
		price = calculatePrice(age,licence,carClass,acc,season);
		Assert.assertNotEquals(23,price, DELTA);

	}

	@Test
	public void accidentsTest() {
		boolean accident = accidents(age,acc);
		Assert.assertFalse(accident);
		acc= true;
		accident = accidents(age,acc);
		Assert.assertTrue(accident);
	}

	@Test
	public void longTermTest() {
		boolean licenceLongTerm = longTerm(licence);
		Assert.assertTrue(licenceLongTerm);
		licence = 2;
		licenceLongTerm = longTerm(licence);
		Assert.assertFalse(licenceLongTerm);
	}

	@Test
	public void highSeasonTest() {
		boolean highSeason = highSeason(age,carClass,season);
		Assert.assertFalse(highSeason);
		season = true;
		carClass = 5;
		highSeason = highSeason(age,carClass,season);
		Assert.assertTrue(highSeason);
	}

	@Test
	public void priceDeductionTest() {
		double price = 1500;
		boolean deduct = priceDeduction(price);
		Assert.assertTrue(deduct);
		price = 1000;
		deduct = priceDeduction(price);
		Assert.assertFalse(deduct);


	}

	@Test
	public void eligibleForRentTest() {
		try{
			eligibleForRent(age,licence,carClass);
		} catch(IllegalArgumentException e ){
			thrown = true;
		}
		Assert.assertFalse(thrown);
		carClass = 1;
		licence = 1;
		try{
			eligibleForRent(age,licence,carClass);
		} catch(IllegalArgumentException e ){
			thrown = true;
		}
		Assert.assertTrue(thrown);

	}

	@Test
	public void atleastYearTest() {
		boolean licenceTerm = atleastYear(licence);
		Assert.assertTrue(licenceTerm);
		licence = 1;
		licenceTerm = atleastYear(licence);
		Assert.assertFalse(licenceTerm);

	}

	@Test
	public void agePermitControlTest() {
		try {
			agePermitControl(age, carClass);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		Assert.assertFalse(thrown);
		age = 17;
		try {
			agePermitControl(age, carClass);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		Assert.assertTrue(thrown);
		thrown = false;
		age = 19;
		carClass = 3;
		try{
			agePermitControl(age,carClass);
		} catch(IllegalArgumentException e ){
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	@Test
	public void ageForClassTest(){

	}
	@Test
	public void isAdultTest(){
		boolean isAdult = isAdult(age);
		Assert.assertTrue(isAdult);
		age = 17;
		isAdult = isAdult(age);
		Assert.assertFalse(isAdult);
	}
}

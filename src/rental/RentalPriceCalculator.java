package rental;

public class RentalPriceCalculator {
	public static void main(String[] args){
		RentalPriceCalculator test = new RentalPriceCalculator();
		System.out.println(test.quotePrice(27,5,5,false,false));
	}

	private static void isDriverUnderage(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
	}

	private static void isYoungDriver(int age, int carSize) {
		if (age <= 21 && carSize > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}

	private static double isHighSeason(double rentalPrice, int driverAge, int carSize, boolean highSeason) {
		if (carSize >=4 && driverAge <= 25 && highSeason) {
			return rentalPrice * 1.5;
		} else return rentalPrice;
	}

	private static void isNewDriver(int yearsWithDriversLicense) {
		if (yearsWithDriversLicense < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	private static double hasLicenceForThreeYears(double rentalPrice, int yearsWithDriversLicense) {
		if (yearsWithDriversLicense < 3) {
		return rentalPrice * 1.3;
		} else return rentalPrice;
	}

	private static double hadAccidentsLastYear(double rentalPrice, boolean anyAccidentsCausedLastYear, int driverAge) {
		if (anyAccidentsCausedLastYear && driverAge < 30) {
			return rentalPrice += 15;
		} else return rentalPrice;
	}

	private static double maxRentPrice(double rentalPrice) {
		if (rentalPrice > 1000) {
			return 1000.00;
		} else return rentalPrice;
	}



	/**
	 * Returns the daily rental price of a car based on input parameters.
	 *
	 * @param  driverAge  age of driver
	 * @param  yearsWithDriversLicense number of full years person holds driving licence
	 * @param  carSize  class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	 * @param  anyAccidentsCausedLastYear has s/he caused any accidents within last year
	 * @param  highSeason if it is high highSeason or not
	 * @return      daily rental price
	 */
	public double quotePrice(int driverAge,
						int yearsWithDriversLicense,
						int carSize,
						boolean anyAccidentsCausedLastYear,
						// boolean involvedInAccidentsLastYear, <-- Not used in this equation
						boolean highSeason) {

		double rentalPrice = driverAge;

		isDriverUnderage(driverAge);
		isYoungDriver(driverAge, carSize);
		isNewDriver(yearsWithDriversLicense);
		rentalPrice = isHighSeason(rentalPrice, driverAge, carSize, highSeason);
		rentalPrice = hasLicenceForThreeYears(rentalPrice, yearsWithDriversLicense);
		rentalPrice = hadAccidentsLastYear(rentalPrice, anyAccidentsCausedLastYear, driverAge);
		rentalPrice = maxRentPrice(rentalPrice);

		return rentalPrice;
	}

}
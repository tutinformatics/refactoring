package rental;

public class RentalPriceCalculator {

	private final int LIMITED_CAR_RENTAL_PERMISSION_AGE = 18;
	private final int FULL_CAR_RENTAL_PERMISSION_AGE = 21;
	private final int EXTRA_CHARGE_DISMISS_AGE = 25;
	
	// driverAge - driverAge of driver
	// licence - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// hadAccident - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// isHighSeason - if it is high isHighSeason or not

	/**
	 *
	 * @param driverAge Age of the driver.
	 * @param licenseAgeInFullYears The amount of time in full years that the driver holds the license.
	 * @param carClass The class of car (1-5).
	 * @param hadAccident If the driver had an accident in the previous year.
	 * @param isHighSeason If it is high season.
	 * @return The rental price of car.
	 */
	public double calculateRentalPrice(int driverAge, int licenseAgeInFullYears, int carClass, boolean hadAccident, boolean isHighSeason) {

		double rentalPrice = driverAge;

		if (isAdult(driverAge)) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}

		if (isFullPermissionAge(driverAge, carClass)) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}

		if (holdsLicenseForUnderAYear(licenseAgeInFullYears)) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}

		if (canApplyDischarge(carClass, driverAge, isHighSeason)) {
			rentalPrice = rentalPrice * 2;
		}
		
		if (isNotExperiencedDriver(licenseAgeInFullYears)) {
			rentalPrice = rentalPrice * 1.3;
		}
		
		if (isYoungAndFoolish(hadAccident, driverAge)) {
			rentalPrice += 15;
		}

		if (isVeryExpensiveCar(rentalPrice)) {
			return 1000.00;
		}

		return rentalPrice;
	}

	private boolean isAdult(int age) {
		return age < LIMITED_CAR_RENTAL_PERMISSION_AGE;
	}

	private boolean isFullPermissionAge(int age, int clazz) {
		return age <= FULL_CAR_RENTAL_PERMISSION_AGE && clazz > 2;
	}

	private boolean canApplyDischarge(int carClass, int driverAge, boolean season) {
		return carClass >=4 && driverAge <= EXTRA_CHARGE_DISMISS_AGE && season;
	}

	private boolean holdsLicenseForUnderAYear(int licenseAgeInFullYears) {
		return licenseAgeInFullYears < 1;
	}

	private boolean isNotExperiencedDriver(int licenseAge) {
		return licenseAge < 3;
	}

	private boolean isYoungAndFoolish(boolean hadAccident, int driverAge) {
		return hadAccident && driverAge < 30;
	}

	private boolean isVeryExpensiveCar(double rentalPrice) {
		return rentalPrice > 1000;
	}


}
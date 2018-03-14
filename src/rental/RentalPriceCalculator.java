package rental;

import Client.Driver;

public class RentalPriceCalculator {
	

	// isHighSeason - if it is high season or not
	public double calculatePrice(Driver driver, Car car, boolean isHighSeason) {


		if (!isAllowedToDrive(driver, car)) {
			return 0.0; // throws exception in method
		}

		int driverAge = driver.getAge();
		int carClass = car.getSizeClass();
		double rentalPrice = driverAge;

		if (carClass >= 4 && driverAge <= 25 && isHighSeason) {
			rentalPrice = rentalPrice * 2;
		}
		

		if (driver.getLicenceAge() < 3) {
			rentalPrice = rentalPrice * 1.3;
		}

		if (driver.isCausedAccident() && driverAge < 30) {
			rentalPrice += 15;
		}

		if (rentalPrice > 1000) {
			return 1000.00;
		}
		return rentalPrice;
	}

	private boolean isAllowedToDrive(Driver driver, Car car){
		if (driver.getAge() < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		} else if (driver.getAge() <= 21 && car.getSizeClass() > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}

		if (driver.getLicenceAge() < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year." +
					" Can not rent a car!");

		}

		return true;
	}
}
package rental;

public class RentalPriceCalculator {
	
	public void price(int driverAge, int yearsLicenceHeld, int carType, boolean isAccidentsCaused,
			boolean isAccidentVictim, boolean isHighSeason) {
		
		isDriverOldEnough(driverAge, carType);
		double rentalPrice = driverAge;
		isDriverExperiencedEnough(yearsLicenceHeld);
		rentalPrice = calculateRentalPrice(driverAge, carType, isAccidentsCaused, isHighSeason, rentalPrice, yearsLicenceHeld);
	}

	 double calculateRentalPrice(int driverAge, int carType, boolean isAccidentsCaused, boolean isHighSeason,
			double rentalPrice, int yearsLicenceHeld) {
		
		if (yearsLicenceHeld < 3) {
			rentalPrice = rentalPrice * 1.3;
		}
		
		if (carType >=4 && driverAge <= 25 && isHighSeason(isHighSeason)) {
			rentalPrice = rentalPrice * 2;
		}
		
		if (isAccidentsCaused == true && driverAge < 30) {
			rentalPrice += 15;
		}

		if (rentalPrice > 1000) {
			rentalPrice = 1000.00;
		}
		
		return rentalPrice;
	}

	boolean isHighSeason(boolean isHighSeason) {
		return isHighSeason != false;
	}

	void isDriverExperiencedEnough(int yearsLicenceHeld) throws IllegalArgumentException {
		if (yearsLicenceHeld < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	void isDriverOldEnough(int driverAge, int carType)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (driverAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (driverAge <= 21 && carType > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}


}
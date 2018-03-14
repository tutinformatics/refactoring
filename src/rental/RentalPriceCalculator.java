package rental;

public class RentalPriceCalculator {
	public double calculateRentalPrice(int driverAge, int drivingExperience, int carClass, boolean isAccidentsCaused, boolean isActiveSeason) {

		carRentAllowed(driverAge, carClass, drivingExperience);

		double rentalPrice = driverAge;

		rentalPrice = calculateRentalPrice(driverAge, drivingExperience, carClass, isAccidentsCaused, isActiveSeason, rentalPrice);

		if (rentalPriceMax(rentalPrice)) return 1000.00;

		return rentalPrice;
	}

	public void carRentAllowed(int driverAge, int carClass, int drivingExperience) {

		if (driverAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}

		if (driverAge <= 21 && carClass > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}

		if (drivingExperience < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	public double calculateRentalPrice(int driverAge, int drivingExperience, int carClass, boolean isAccidentsCaused, boolean isActiveSeason, double rentalPrice) {

		if (carClass >=4 && driverAge <= 25 && isActiveSeason != false) {
			rentalPrice = rentalPrice * 2;
		}

		if (drivingExperience < 3) {
			rentalPrice = rentalPrice * 1.3;
		}

		if (isAccidentsCaused == true && driverAge < 30) {
			rentalPrice += 15;
		}
		return rentalPrice;
	}

	public boolean rentalPriceMax(double rentalPrice) {
		if (rentalPrice > 1000) {
			return true;
		}
		return false;
	}
}
package rental;

public class RentalPriceCalculator {
	
	// driverAge - age of driver
	// driverLicence - number of full years person holds driving license
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// causedAccident - has s/he caused any accidents within last year
	// beenInAccidents - has s/he participated (but not caused) in any accidents within last year
	// isHighSeason - if it is high season or not
	public double getPrice(int driverAge, int driverLicence, int carClass, boolean causedAccident, boolean beenInAccidents,
						   boolean isHighSeason) {
		if (driverAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (driverAge <= 21 && carClass > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalPrice = driverAge;
		
		if (carClass >=4 && driverAge <= 25 && isHighSeason) {
			rentalPrice = rentalPrice * 2;
		}
		if (driverLicence < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (driverLicence < 3) {
			rentalPrice = rentalPrice * 1.3;
		}
		
		if (causedAccident && driverAge < 30) {
			rentalPrice += 15;
		}

		if (rentalPrice > 1000) {
			return 1000.00;
		}
		return rentalPrice;
	}
}
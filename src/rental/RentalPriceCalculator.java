package rental;

public class RentalPriceCalculator {
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	public double price(int driverAge, int driversLicenseAge, int carType, boolean accidentsCaused, boolean isHighSeason) {
		
		if (isUnderage(driverAge)) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (canRentOnlyClassOneCars(driverAge, carType)) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalprice = driverAge;

		if (isCarLargeWithYoungDriverDuringHighSeason(driverAge, carType, isHighSeason)) {
			rentalprice = rentalprice * 2;
		}

		if (isLicenseNew(driversLicenseAge)) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (isLicenseStillFresh(driversLicenseAge)) {
			rentalprice = rentalprice * 1.3;
		}
		
		if (youngerDrivreHasCausedAccidentsInLastYear(driverAge, accidentsCaused)) {
			rentalprice += 15;
		}

		if (isRentalPriceTooHigh(rentalprice)) {
			return 1000.00;
		}
		return rentalprice;
	}

	private boolean isRentalPriceTooHigh(double rentalprice) {
		return rentalprice > 1000;
	}

	private boolean youngerDrivreHasCausedAccidentsInLastYear(int driverAge, boolean accidentsCaused) {
		return accidentsCaused && driverAge < 30;
	}

	private boolean isLicenseStillFresh(int driversLicenseAge) {
		return driversLicenseAge < 3;
	}

	private boolean isLicenseNew(int driversLicenseAge) {
		return driversLicenseAge < 1;
	}

	private boolean isCarLargeWithYoungDriverDuringHighSeason(int driverAge, int carType, boolean isHighSeason) {
		return carType >=4 && driverAge <= 25 && isHighSeason;
	}

	private boolean canRentOnlyClassOneCars(int driverAge, int carType) {
		return driverAge <= 21 && carType > 2;
	}

	private boolean isUnderage(int driverAge) {
		return driverAge < 18;
	}
}
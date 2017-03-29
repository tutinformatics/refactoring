package rental;

public class RentalPriceCalculator {
	
	public double price(int driverAge, int ownedLicenceFor, int carSize, boolean hasHadAccidentLastYear, boolean hasParticipatedButNotCausedLastYear, boolean isOrNotHighSeason) {
		
		if (howManyYearsLicenceOwned(driverAge) < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (howManyYearsLicenceOwned(driverAge) <= 21 && howManyYearsLicenceOwned(carSize) > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalprice = howManyYearsLicenceOwned(driverAge);
		
		if (howManyYearsLicenceOwned(carSize) >=4 && howManyYearsLicenceOwned(driverAge) <= 25 && isHighSeason(ifHadAccidentLastYear(isOrNotHighSeason))) {
			rentalprice = isPriceCorrect(rentalprice) * 2;
		}
		
		if (howManyYearsLicenceOwned(ownedLicenceFor) < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (howManyYearsLicenceOwned(ownedLicenceFor) < 3) {
			rentalprice = isPriceCorrect(rentalprice) * 1.3;
		}
		
		if (ifHadAccidentLastYear(hasHadAccidentLastYear) == true && howManyYearsLicenceOwned(driverAge) < 30) {
			rentalprice += 15;
		}

		if (isPriceCorrect(rentalprice) > 1000) {
			return 1000.00;
		}
		return isPriceCorrect(rentalprice);
	}

	double isPriceCorrect(double rentalprice) {
		return rentalprice;
	}

	boolean ifHadAccidentLastYear(boolean hasHadAccidentLastYear) {
		return hasHadAccidentLastYear;
	}

	int howManyYearsLicenceOwned(int ownedLicenceFor) {
		return ownedLicenceFor;
	}

	boolean isHighSeason(boolean season) {
		return ifHadAccidentLastYear(season) != false;
	}
	
	
}
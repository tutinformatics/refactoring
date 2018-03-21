package rental;


public class RentalPriceCalculator {
    
    public static final int minimumLegalAge = 18;
    public static final int fullLegalAge = 21;
    public static final int maxRentalPrice = 1000;
    public static final int firstRiskGroupAge = 25;
    public static final int secondRiskGroupAge = 30;
    
    
	public double price(int ageOfDriver, int hadLicenseForYears, int carSizeClass, boolean hasCausedAccidentsLastYear, boolean hasParticipatedInAccidentsLastYear, boolean ifHighSeason) {
		
		checkIfDriverLegalAge(ageOfDriver);
		
		checkIfDriverIsSuitableForClass(ageOfDriver, carSizeClass);
		
		double rentalprice = ageOfDriver;
		
		rentalprice = adaptPriceOnSeasonCarClassDriversAge(ageOfDriver, carSizeClass, ifHighSeason, rentalprice);
		
		checkIfLicenseUnderYear(hadLicenseForYears);
		
		rentalprice = adaptPriceOnDriversPeriod(hadLicenseForYears, rentalprice);
		
		rentalprice = adaptPriceOnDriversAccidentsAndAge(ageOfDriver, hasCausedAccidentsLastYear, rentalprice);

		if (rentalprice > maxRentalPrice) {
			return maxRentalPrice;
		}
		
		return rentalprice;
	}


	void checkIfDriverLegalAge(int ageOfDriver) {
		if (ageOfDriver < minimumLegalAge) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
	}


	void checkIfDriverIsSuitableForClass(int ageOfDriver, int carSizeClass) {
		if (ageOfDriver <= fullLegalAge && carSizeClass > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}


	double adaptPriceOnSeasonCarClassDriversAge(int ageOfDriver, int carSizeClass, boolean ifHighSeason,
			double rentalprice) {
		if (carSizeClass >= 4 && ageOfDriver <= firstRiskGroupAge && !ifHighSeason) {
			rentalprice = rentalprice * 2;
		}
		return rentalprice;
	}


	double adaptPriceOnDriversAccidentsAndAge(int ageOfDriver, boolean hasCausedAccidentsLastYear,
			double rentalprice) {
		if (hasCausedAccidentsLastYear && ageOfDriver < secondRiskGroupAge) {
			rentalprice += 15;
		}
		return rentalprice;
	}


	void checkIfLicenseUnderYear(int hadLicenseForYears) {
		if (hadLicenseForYears < 1) {
			throw new IllegalArgumentException("Driver must hold driving hadLicenseForYears at least for one year. Can not rent a car!");
		}
	}


	double adaptPriceOnDriversPeriod(int hadLicenseForYears, double rentalprice) {
		if (hadLicenseForYears < 3) {
			rentalprice = rentalprice * 1.3;
		}
		return rentalprice;
	}
}
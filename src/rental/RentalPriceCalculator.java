package rental;

public class RentalPriceCalculator {
	// driverAge - age of driver
	// driverLicence - number of full years person holds driving license
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// causedAccident - has s/he caused any accidents within last year
	// beenInAccidents - has s/he participated (but not caused) in any accidents within last year
	// isHighSeason - if it is high season or not

	public double getRentalPrice(int driverAge, int driverLicenceAge, int carClass, boolean isHighSeason, boolean causedAccident) {
	    if (isEligibleToRent(driverAge, carClass, driverLicenceAge)) {
        return rentalPriceCalculator(carClass, driverAge, isHighSeason, driverLicenceAge, causedAccident);
    } else {
	        return 0;
        }
	}
    public double rentalPriceCalculator(int carClass, int driverAge, boolean isHighSeason, int driverLicence, boolean causedAccident){
        double rentalPrice = driverAge;
        if (isCarClassHighModifier(carClass,driverAge,isHighSeason)) {
            rentalPrice = rentalPrice * 2;
        }
        if (isDriversLicenceModifier(driverLicence)) {
            rentalPrice = rentalPrice * 1.3;
        }
        if (isCausedAccidentModifier(causedAccident,driverAge)) {
            rentalPrice += 15;
        }
        if (isRentalPriceOverThousand(rentalPrice)) {
            return 1000;
        }
        return rentalPrice;
    }
    private boolean  isDriversLicenceModifier(int driverLicenceAge) {
	    return driverLicenceAge < 3;
    }
    private boolean isCausedAccidentModifier(boolean causedAccident, int driverAge) {
	    return causedAccident && driverAge < 30;
    }
    private boolean isRentalPriceOverThousand(double rentalPrice) {
	    return rentalPrice > 1000;
    }
    private boolean isCarClassHighModifier( int carClass, int driverAge, boolean highSeason) {
	    return carClass >=4 && driverAge <= 25 && highSeason;
    }
    public boolean isAdult(int driverAge) {
        if (driverAge < 18) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        } else {
            return true;
        }
    }
    public boolean isDriverLicenseValid( int driverLicenceAge) {
	    if (driverLicenceAge < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        } else {
	        return true;
	    }
    }
    public void canOnlyRentClassOne(int driverAge, int carClass) {
	    if (driverAge <= 21 && carClass > 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }
    }
    public boolean isEligibleToRent (int driverAge, int carClass, int driverLicenceAge) {
	    return isAdult(driverAge) && isDriverLicenseValid(driverLicenceAge);
    }
}

package rental;

public class RentalPriceCalculator {
    private static final double MAXIMUM_PRICE_PER_DAY = 1000.00;
    private static final int ADDITIONAL_FEE = 15;
    private static final double LICENSE_NEW_PRICE_COEFFICIENT = 1.3;

    public double calculateRentalPrice(int driverAge, int licenceDurationYears, int priceCategory, boolean hasCausedLastYearAccidents, boolean isHighSeason) {
	    validateRenterOrThrow(driverAge, licenceDurationYears, priceCategory);
		
		double rentalprice = getMinimumRentalPrice(driverAge);
		
		if (priceCategory >= 4) {
		    rentalprice = getHigherClassRentalPrice(rentalprice, driverAge, isHighSeason);
		}
		
		if (licenceDurationYears < 3) {
			rentalprice = rentalprice * LICENSE_NEW_PRICE_COEFFICIENT;
		}
		
		if (getsAdditionalFee(driverAge, hasCausedLastYearAccidents)) {
			rentalprice += ADDITIONAL_FEE;
		}

		if (rentalprice > MAXIMUM_PRICE_PER_DAY) {
            return MAXIMUM_PRICE_PER_DAY;
		}

		return rentalprice;
	}

    private static boolean getsAdditionalFee(int driverAge, boolean hasCausedLastYearAccidents) {
        return hasCausedLastYearAccidents && driverAge < 30;
    }

    private static double getHigherClassRentalPrice(double currentPrice, int driverAge, boolean isHighSeason) {
	    if (driverAge <= 25 && isHighSeason) {
	        return currentPrice * 2.0;
        }
        else return currentPrice;
    }

    private static int getMinimumRentalPrice(int driverAge) {
        return driverAge;
    }

    private static void validateRenterOrThrow(int driverAge, int licenceDurationYears, int priceCategory) {
        if (!canRent(driverAge)) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }

        if (!canRentHigherClassVehicles(driverAge) && priceCategory > 2) {
            throw new IllegalArgumentException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }

        if (licenceDurationYears < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
    }

    private static boolean canRentHigherClassVehicles(int driverAge) {
        return driverAge <= 21;
    }

    private static boolean canRent(int driverAge) {
		return driverAge >= 18;
	}
}
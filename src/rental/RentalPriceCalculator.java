package rental;

public class RentalPriceCalculator {

    private static final int MIN_AGE = 18;
    private static final int MIN_AGE_FOR_CLASS_2 = 21;
    private static final double MAX_RENTAL_PRICE = 1000;

    /**
     * Calculates rent price for user according to their data.
     * @param driverAge - Age of the driver
     * @param licenseHoldingYears - How many years has the driver held their license
     * @param carClass - Class of car (1 - 5)
     * @param hasCausedAccidents - Have they caused any accidents before.
     * @param isHighSeason - Is high season or not.
     * @return the calculated rental price.
     */
    public double calculatePrice(int driverAge, int licenseHoldingYears, int carClass,
                                 boolean hasCausedAccidents, boolean isHighSeason) {
        double rentalPrice = driverAge;

        checkDriverAge(driverAge, carClass);
        checkHasHeldLicenseForEnoughYears(licenseHoldingYears);
        rentalPrice = incrementRentalPriceIfCarClassOverFour(driverAge, carClass, isHighSeason, rentalPrice);
        rentalPrice = incrementRentalPriceIfNotHeldLicenseEnough(licenseHoldingYears, rentalPrice);
        rentalPrice = incrementRentalPriceIfCausedAnyAccidents(driverAge, hasCausedAccidents, rentalPrice);

        return limitedRentalPrice(rentalPrice);
    }

    private double incrementRentalPriceIfCarClassOverFour(int driverAge, int carClass, boolean isHighSeason, double rentalPrice) {
        if (carClass >= 4 && driverAge <= 25 && isHighSeason) {
            rentalPrice = rentalPrice * 2;
        }
        return rentalPrice;
    }

    private double incrementRentalPriceIfCausedAnyAccidents(int driverAge, boolean hasCausedAccidents, double rentalPrice) {
        if (hasCausedAccidents && driverAge < 30) {
            rentalPrice += 15;
        }
        return rentalPrice;
    }

    private double incrementRentalPriceIfNotHeldLicenseEnough(int licenseHoldingYears, double rentalPrice) {
        if (licenseHoldingYears < 3) {
            rentalPrice = rentalPrice * 1.3;
        }
        return rentalPrice;
    }

    private double limitedRentalPrice(double rentalPrice) {
        if (rentalPrice > MAX_RENTAL_PRICE) {
            return MAX_RENTAL_PRICE;
        }

        return rentalPrice;
    }

    private void checkHasHeldLicenseForEnoughYears(int licenseHoldingYears) {
        if (licenseHoldingYears < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
    }

    private void checkDriverAge(int driverAge, int carClass) {
        if (driverAge < MIN_AGE) {
            throw new IllegalArgumentException("Driver too young - cannot quote the calculatePrice");
        }
        if (driverAge <= MIN_AGE_FOR_CLASS_2 && carClass > 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }
    }
}
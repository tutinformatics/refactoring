package rental;

public class RentalPriceCalculator {
    private static final int MINIMUM_DRIVING_AGE = 18;
    private static final int MAXIMUM_DAILY_PRICE = 1000;
    private static final int MINIMUM_CLASS1_AGE = 21;
    private static final int MINIMUM_LICENSE_THRESHOLD = 3;
    private static final double NEW_CLIENT_COEFFICIENT = 1.3;
    private static final double NORMAL_PRICE = 1000.00;
    private static final int RENTAL_PRICE_INCREASE_BY_CAUSED_ACCIDENTS = 15;
    private static final int DRIVER_AGE_THRESHOLD = 30;
    private static final int DRIVER_AGE_THRESHOLD_HIGHER_SEASON = 25;
    private static final int MINIMUM_LUXURY_CAR_CLASS = 4;
    private static final int MINIMUM_LICENSE_YEARS = 1;
    private static final int CAR_CLASS_THRESHOLD_BY_MINIMUM_AGE = 2;
    private static final int RENTAL_PRICE_COEFFICIENT_BY_LUXURY_CAR_AND_HIGH_SEASON = 2;

    private static final String ERROR_DRIVER_TOO_YOUNG =
            "Driver too young - cannot quote the getCarRentDailyPrice";
    private static final String ERROR_MINIMUM_LICENSE_YEARS_NOT_MET =
            "Driver must hold driving license at least for one year. Can not rent a car!";
    private static final String ERROR_DRIVER_LESS_THAN_21YO =
            "Drivers 21 y/o or less can only rent Class 1 vehicles";

    /**
     * Get car rental daily price.
     * @param driverAge age of driver
     * @param licenseYears number of full years person holds driving license
     * @param carClass class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
     * @param causedAccidents has s/he caused any accidents within last year
     * @param isHighSeason if it is high season or not
     * @return Car rental daily price.
     */
    public double getCarRentDailyPrice(int driverAge, int licenseYears, int carClass,
                                       boolean causedAccidents, boolean isHighSeason)
    {
        double rentalPrice = driverAge;

        if (isMinimumAgeReached(driverAge)) {
            throw new IllegalArgumentException(ERROR_DRIVER_TOO_YOUNG);
        }

        if (driverAge <= MINIMUM_CLASS1_AGE && carClass > CAR_CLASS_THRESHOLD_BY_MINIMUM_AGE) {
            throw new UnsupportedOperationException(ERROR_DRIVER_LESS_THAN_21YO);
        }

        if (isLuxuryCar(carClass) && isHigherPrice(driverAge, isHighSeason)) {
            rentalPrice = rentalPrice * RENTAL_PRICE_COEFFICIENT_BY_LUXURY_CAR_AND_HIGH_SEASON;
        }

        if (isMinimumLicenseYears(licenseYears)) {
            throw new IllegalArgumentException(ERROR_MINIMUM_LICENSE_YEARS_NOT_MET);
        }

        if (isNewClient(licenseYears)) {
            rentalPrice = rentalPrice * NEW_CLIENT_COEFFICIENT;
        }

        if (isConditionForIncreasedPrice(driverAge, causedAccidents)) {
            rentalPrice += RENTAL_PRICE_INCREASE_BY_CAUSED_ACCIDENTS;
        }

        if (isMaximumDailyPriceReached(rentalPrice)) {
            return NORMAL_PRICE;
        }

        return rentalPrice;
    }

    private boolean isConditionForIncreasedPrice(int driverAge, boolean causedAccidents) {
        return causedAccidents && driverAge < DRIVER_AGE_THRESHOLD;
    }

    private boolean isHigherPrice(int driverAge, boolean isHighSeason) {
        return driverAge <= DRIVER_AGE_THRESHOLD_HIGHER_SEASON && isHighSeason;
    }

    private boolean isLuxuryCar(int carClass) {
        return carClass >= MINIMUM_LUXURY_CAR_CLASS;
    }

    private boolean isMinimumLicenseYears(int licenseYears) {
        return licenseYears < MINIMUM_LICENSE_YEARS;
    }

    private boolean isNewClient(int licenseYears) {
        return licenseYears < MINIMUM_LICENSE_THRESHOLD;
    }

    private boolean isMinimumAgeReached(int driverAge) {
        return driverAge < MINIMUM_DRIVING_AGE;
    }

    private boolean isMaximumDailyPriceReached(double rentalPrice) {
        return rentalPrice > MAXIMUM_DAILY_PRICE;
    }
}
package rental;

public class RentalPriceCalculator {

    private static final int MINIMUM_AGE_OF_ADULT = 18;
    private static final int LOWEST_CAR_CLASS = 1;
    private static final int HIGHEST_CAR_CLASS = 5;
    private static final int MAXIMUM_RENTAL_PRICE_PER_DAY = 1000;
    private static final int MINIMUM_DRIVING_EXPERIENCE_IN_YEARS = 1;
    private static final int ADDITIONAL_RENTAL_PRICE_FOR_YOUNG_DRIVERS = 15;
    private static final double RENTAL_PRICE_COEFFICIENT_FOR_NEW_DRIVERS = 1.3;

    public double price(int ageOfDriver, int licenceDurationInYears, int carClass,
                        boolean hasOwnAccidentsLastYear, boolean isHighSeason) {

        if (!isAdult(ageOfDriver)) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }

        if (canDriveHigherClassCar(ageOfDriver, carClass)) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }

        double rentalPrice = ageOfDriver;

        if (priceShouldBeHigherForYoungDriversDuringHighSeason(ageOfDriver, carClass, isHighSeason)) {
            rentalPrice = rentalPrice * 2;
        }

        if (licenceDurationInYears < MINIMUM_DRIVING_EXPERIENCE_IN_YEARS) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }

        if (licenceDurationInYears < 3) {
            rentalPrice = rentalPrice * RENTAL_PRICE_COEFFICIENT_FOR_NEW_DRIVERS;
        }

        if (shouldIncreaseRentalPriceDueToAccidents(ageOfDriver, hasOwnAccidentsLastYear)) {
            rentalPrice += ADDITIONAL_RENTAL_PRICE_FOR_YOUNG_DRIVERS;
        }

        rentalPrice = Math.min(rentalPrice, MAXIMUM_RENTAL_PRICE_PER_DAY);

        return rentalPrice;
    }

    private boolean priceShouldBeHigherForYoungDriversDuringHighSeason(int ageOfDriver, int carClass, boolean isHighSeason) {
        return carClass + 1 >= HIGHEST_CAR_CLASS && ageOfDriver <= 25 && isHighSeason;
    }

    private boolean canDriveHigherClassCar(int ageOfDriver, int carClass) {
        return ageOfDriver <= 21 && carClass > LOWEST_CAR_CLASS;
    }

    private boolean shouldIncreaseRentalPriceDueToAccidents(int ageOfDriver, boolean hasOwnAccidentsLastYear) {
        return hasOwnAccidentsLastYear && ageOfDriver < 30;
    }

    private boolean isAdult(int ageOfDriver) {
        return ageOfDriver >= MINIMUM_AGE_OF_ADULT;
    }
}
package rental;

public class RentalPriceCalculator {

    private static final int MIN_DRIVER_AGE = 18;
    private static final int MIN_HIGH_CLASS_DRIVER_AGE = 21;
    private static final int FIRST_HIGH_CLASS_INDEX = 2;
    private static final int MIN_LICENSE_AGE = 1;
    private static final int LICENCE_PENALTY_AGE = 3;
    private static final int MAX_RENTAL_PRICE = 1000;
    private static final double LICENCE_PENALTY = 1.3;
    private static final int CAR_CLASS_PENALTY = 2;
    private static final int ACCIDENT_PENALTY = 15;
    private static final int FIRST_LUXURY_CLASS_INDEX = 4;

    public double price(int driverAge, int licenceAge, int carClass, boolean wasAccidentLastYear, boolean isSeasonHigh) {

        if (driverAge < MIN_DRIVER_AGE) {
            throw new UnsupportedOperationException("Driver too young - cannot quote the price");
        }
        if (driverAge <= MIN_HIGH_CLASS_DRIVER_AGE && carClass > FIRST_HIGH_CLASS_INDEX) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }
        if (licenceAge < MIN_LICENSE_AGE) {
            throw new UnsupportedOperationException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }

        double rentalPrice = driverAge;

        if (carClass >= FIRST_LUXURY_CLASS_INDEX && driverAge <= 25 && !isSeasonHigh) {
            rentalPrice *= CAR_CLASS_PENALTY;
        }

        if (licenceAge < LICENCE_PENALTY_AGE) {
            rentalPrice *= LICENCE_PENALTY;
        }

        if (wasAccidentLastYear && driverAge < 30) {
            rentalPrice += ACCIDENT_PENALTY;
        }

        if (rentalPrice > MAX_RENTAL_PRICE) {
            return MAX_RENTAL_PRICE;
        }
        return rentalPrice;
    }

}
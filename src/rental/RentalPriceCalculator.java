package rental;

public class RentalPriceCalculator {

    private static final int RENTAL_COEFFICIENT_LESS_E_25_AGE = 2;
    private static final double RENTAL_COEFFICIENT_NOT_ENOUGH_DRIVE_EXPERIENCE = 1.3;
    private static final int RENTAL_ADD_EXTRA_FOR_ACCIDENTS = 15;
    private static final double RENTAL_MAX_PRICE = 1000.0;

    public double getRentalPrice(int personAge, int personDriveAge, int carClassType,
                                 boolean hasPersonAccident, boolean hasPersonAccidentWhereNotGuilty,
                                 boolean isSeasonHype) {
        double rentalPrice = personAge;

        checkAgeRestriction(personAge, personDriveAge, carClassType);

        if (personAge <= 25 && carClassType >= 4 && !isSeasonHype) {
            rentalPrice *= RENTAL_COEFFICIENT_LESS_E_25_AGE;
        }
        if (personDriveAge < 3) {
            rentalPrice *= RENTAL_COEFFICIENT_NOT_ENOUGH_DRIVE_EXPERIENCE;
        }
        if (personAge < 30 && hasPersonAccident) {
            rentalPrice += RENTAL_ADD_EXTRA_FOR_ACCIDENTS;
        }
        return Math.min(rentalPrice, RENTAL_MAX_PRICE);
    }

    private void checkAgeRestriction(int personAge, int personDriveAge, int carClassType) {
        if (personAge < 18) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }
        if (personDriveAge < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
        if (personAge <= 21 && carClassType > 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }
    }
}
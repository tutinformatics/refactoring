package rental;

public class RentalPriceCalculator {

    /**
     * Maximum possible rental price per day.
     */
    private static final int MAXIMUM_RENTAL_PRICE = 1000;

    /**
     * Minimum eligible age for rental.
     */
    private static final int MINIMUM_ELIGIBLE_AGE = 18;

    /**
     * Extra expense added if has caused an accident within last year and age below 30.
     */
    private static final int ACCIDENT_EXTRA = 15;

    /**
     * If license age of driver is below three years, beginner driver expense is added.
     */
    private static final double BEGINNER_DRIVER_EXPENSE_FACTOR = 1.3;


    /**
     * Calculate the price of rental.
     *
     * @param age                age of driver
     * @param licenseAge         number of full years person holds driving license
     * @param carClass           car class of the car from 1 (smallest) to 5 (largest) that person can rent
     * @param hasCausedAccidents true if has caused any accidents within last year
     * @param isHighSeason       true if is high season, else false
     * @return price of rental
     */
    public double calculateRentalPrice(int age,
                                       int licenseAge,
                                       int carClass,
                                       boolean hasCausedAccidents,
                                       boolean isHighSeason) {

        checkEligibility(age, licenseAge, carClass);

        double rentalPrice = age;

        if (carClass >= 4 && age <= 25 && isHighSeason) {
            rentalPrice *= 2;
        }
        if (licenseAge < 3) {
            rentalPrice *= BEGINNER_DRIVER_EXPENSE_FACTOR;
        }
        if (hasCausedAccidents && age < 30) {
            rentalPrice += ACCIDENT_EXTRA;
        }
        return Math.min(rentalPrice, MAXIMUM_RENTAL_PRICE);
    }

    /**
     * Check eligibility of car rental.
     * If not eligible, throw an error.
     *
     * @param age        age of driver
     * @param licenseAge number of full years person holds driving license
     * @param carClass   car class of the car from 1 (smallest) to 5 (largest) that person can rent
     */
    private void checkEligibility(int age, int licenseAge, int carClass) {
        if (age < MINIMUM_ELIGIBLE_AGE) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        } else if (age <= 21 && carClass > 1) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        } else if (licenseAge < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
    }

    public static void main(String[] args) {
        System.out.println("abc");
    }
}
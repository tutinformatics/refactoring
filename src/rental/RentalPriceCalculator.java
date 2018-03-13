package rental;

public class RentalPriceCalculator {

    /**
     * Calculate the price of rental.
     *
     * @param age                        age of driver
     * @param licenseAge                 number of full years person holds driving license
     * @param carClass                   car class of the car from 1 (smallest) to 5 (largest) that person can rent
     * @param hasCausedAccidents         true if has caused any accidents within last year
     * @param hasParticipatedInAccidents true if has participated in accidents within last year, false otherwise
     * @param isHighSeason               true if is high season, else false
     * @return price of rental
     */
    public double calculateRentalPrice(int age,
                                       int licenseAge,
                                       int carClass,
                                       boolean hasCausedAccidents,
                                       boolean hasParticipatedInAccidents,
                                       boolean isHighSeason) {

        checkEligibility(age, licenseAge, carClass);

        double rentalPrice = age;

        if (carClass >= 4 && age <= 25 && isHighSeason) {
            rentalPrice *= 2;
        }
        if (licenseAge < 3) {
            rentalPrice *= 1.3;
        }
        if (hasCausedAccidents && age < 30) {
            rentalPrice += 15;
        }
        return Math.min(rentalPrice, 1000);
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
        if (age < 18) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        } else if (age <= 21 && carClass > 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        } else if (licenseAge < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
    }

    public static void main(String[] args) {
        System.out.println("abc");
    }
}
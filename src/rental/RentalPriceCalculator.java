package rental;

public class RentalPriceCalculator {

    private final int ADULT_AGE = 18;
    private final int CAR_CLASS_FOUR = 4;
    private final int MAX_YOUTH_AGE = 25;
    private final int YOUNG_ADULT = 21;
    private final double PRICE_RATE_FIFTY = 1.5;
    private final String MESSAGES_DRIVER_TOO_YOUNG = "Driver too young - cannot quote the price";
    private final String YOUTH_DRIVE_MESSAGES = "Drivers 21 y/o or less can only rent Class 1 vehicles";
    private final double PRICE_RATE_THIRTY = 1.3;
    private final int CAR_LICENCE_THREE_YEARS = 3;
    private final int MAX_PRICE = 1000;
    private final int ADULT_AGE_THIRTY = 30;
    private final int FIFTEEN_EUROS = 15;
    private final int CAR_CLASS_TWO = 2;
    private final int CAR_LICENCE_MIN_YEAR = 1;
    private final String ONE_YEAR_LICENCE_MESSAGES = "Driver must hold driving licence at least for one year. Can not rent a car!";

	public double calculatePrice(int age, int licence, int carClass, boolean hasCausedAccidents, boolean isHighSeason) {
		double rentalPrice = age;

        isUnderageDriver(age);
        isYoungDriver(age, carClass);
        rentalPrice = doublePrice(age, carClass, isHighSeason, rentalPrice);
        isUnderageDriver(licence);
        oneYearLicence(licence);
        rentalPrice = higherPrice(licence, rentalPrice);
        rentalPrice = hasCausedAccidents(age, hasCausedAccidents, rentalPrice);

        if (isMaxRentalPrice(rentalPrice)) {
            return MAX_PRICE;
        }
        return rentalPrice;
    }

    private void isUnderageDriver(int age) {
        if (age < ADULT_AGE) {
            throw new IllegalArgumentException(MESSAGES_DRIVER_TOO_YOUNG);
        }
    }

    private void isYoungDriver(int age, int carClass) {
        if (age <= YOUNG_ADULT && carClass > CAR_CLASS_TWO) {
            throw new UnsupportedOperationException(YOUTH_DRIVE_MESSAGES);
        }
    }

    private boolean isMaxRentalPrice(double rentalPrice) {
        return rentalPrice > MAX_PRICE;
    }

    private double doublePrice(int age, int carClass, boolean isHighSeason, double rentalPrice) {
        if (carClass >= CAR_CLASS_FOUR && age <= MAX_YOUTH_AGE && isHighSeason) {
            rentalPrice = rentalPrice * PRICE_RATE_FIFTY;
        }
        return rentalPrice;
    }

    private void oneYearLicence (int licence){
	    if(licence <= CAR_LICENCE_MIN_YEAR) {
	        throw new IllegalArgumentException(ONE_YEAR_LICENCE_MESSAGES);}
    }

    private double higherPrice(int licence, double rentalPrice) {
        if (licence < CAR_LICENCE_THREE_YEARS) {
            rentalPrice = rentalPrice * PRICE_RATE_THIRTY;
        }
        return rentalPrice;
    }

    private double hasCausedAccidents(int age, boolean hasCausedAccidents, double rentalPrice) {
        if (hasCausedAccidents && age < ADULT_AGE_THIRTY) {
            rentalPrice += FIFTEEN_EUROS;
        }
        return rentalPrice;
    }
}
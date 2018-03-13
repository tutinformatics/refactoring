package rental;

/**
 * Calculator for finding a the rental calculate of a car based on parameters
 * associated with the client and the rental car.
 */
public class RentalPriceCalculator {

    private static final int MIN_DAYS_HOLDING_LICENSE = 365;
    private static final int LEGAL_AGE_OF_ADULT = 18;
    private static final int DAYS_HOLDING_LICENSE_LONGER = MIN_DAYS_HOLDING_LICENSE * 3;
    private static final double MAX_RENTAL_PRICE = 1000.00;

    /**
     *
     */
    private final CarRentalClient client;

    /**
     *
     */
    private final RentalCar car;

    /**
     *
     * @param client
     * @param car
     */
    RentalPriceCalculator(CarRentalClient client, RentalCar car) {
        this.client = client;
        this.car = car;
    }

    public CarRentalClient getClient() {
        return client;
    }

    public RentalCar getCar() {
        return car;
    }

    public boolean isClientHoldingLicenseForMinimumRequiredTime() {
        return getClient().getNumberOfDaysHoldingLicense() > MIN_DAYS_HOLDING_LICENSE;
    }

    public boolean isClientAdult() {
        return getClient().getAge() >= LEGAL_AGE_OF_ADULT;
    }

    public boolean isClientOfAgeNotEligibleForHigherClassCar() {
        return getClient().getAge() <= 21
                && getCar().getClassCategory() >= RentalCar.CLASS_CATEGORY_LOW;
    }

    public boolean isClientOfAgeRentingHighClassCar(boolean isHighSeason) {
        return getClient().getAge() <= 25 
                && getCar().getClassCategory() >= 4
                && isHighSeason;
    }

    public boolean isClientHoldingLicenseForLongerTime() {
        return getClient().getNumberOfDaysHoldingLicense() > DAYS_HOLDING_LICENSE_LONGER;
    }

    public boolean isClientOfAgeProneToAccidents() {
        return getClient().getAge() < 30
                && getClient().hasCausedAccidentsRecently();
    }

    /**
     *
     * @param isHighSeason True if it is currently high season.
     * @return Price of rental car for one day.
     */
	public double calculate(boolean isHighSeason) {
        double rentalPrice = getClient().getAge();

		if (!isClientAdult()) {
			throw new IllegalArgumentException("Client is too young");
		}

		if (isClientOfAgeNotEligibleForHigherClassCar()) {
			throw new UnsupportedOperationException("Clients under the age of 21 can only rent Class 1 (lowest class) vehicles");
		}
		
		if (isClientOfAgeRentingHighClassCar(isHighSeason)) {
			rentalPrice += rentalPrice * 0.5;
		}
		
		if (!isClientHoldingLicenseForMinimumRequiredTime()) {
			throw new IllegalArgumentException("Client must hold driving licence for at least one year");
		}
		
		if (!isClientHoldingLicenseForLongerTime()) {
			rentalPrice = rentalPrice * 1.3;
		}
		
		if (isClientOfAgeProneToAccidents()) {
			rentalPrice += 15;
		}

		if (rentalPrice > MAX_RENTAL_PRICE) {
			return MAX_RENTAL_PRICE;
		} else {
            return rentalPrice;
        }
	}
}

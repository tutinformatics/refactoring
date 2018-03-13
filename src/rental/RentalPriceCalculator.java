package rental;

public class RentalPriceCalculator {

    private double rentalPrice;

	public double price(int ageOfDriver, int drivingExperienceInYears, int carClass,
						boolean causedAccidentsForTheLastYear, boolean isHighSeason) {
		
	    checkAgeOfDriver(ageOfDriver, carClass);

		this.rentalPrice = ageOfDriver;

		if (isPriceIncreased(ageOfDriver, carClass, isHighSeason)) {
            this.rentalPrice *= 2;
		}

		checkDrivingExperience(drivingExperienceInYears);

        if (causedAccidentsForTheLastYear && ageOfDriver < 30) {
            this.rentalPrice += 15;
        }

		return getFinalRentalPrice();
	}

	public void checkAgeOfDriver(int ageOfDriver, int carClass) {

        if (ageOfDriver < 18) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }
        if (ageOfDriver <= 21 && carClass >= 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }
    }

    public void checkDrivingExperience(int drivingExperienceInYears) {
        if (drivingExperienceInYears < 3) {
            this.rentalPrice *= 1.3;
        }

        if (drivingExperienceInYears < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
    }

    public double getFinalRentalPrice() {
	    return this.rentalPrice > 1000 ? 1000.00 : this.rentalPrice;
    }

    public boolean isPriceIncreased(int ageOfDriver, int carClass, boolean isHighSeason) {
	    return carClass >= 4 && ageOfDriver <= 25 && ageOfDriver >= 22 && !isHighSeason;
    }

    public double getRentalPrice() {
	    return this.rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
	    this.rentalPrice = rentalPrice;
    }
}
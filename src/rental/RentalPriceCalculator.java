package rental;

public class RentalPriceCalculator {

	public static final int TWENTY_FIVE_YEARS = 25;
	public static final int THIRTY_YEARS = 30;
	public static final int PLUS_FIFTEEN_EURO = 15;
	public static final int EIGHTEEN_YEARS = 18;
	public static final int TWENTY_ONE_YEARS = 21;
	public static final double MAX_RENT_PRICE = 1000.00;


	public double calculateRentalPrice(int ageOfTheDriver, int yearsHoldingDriverLicence, int classOfTheCar, boolean hasCausedAccidentsLastYear, boolean highSeason) {

		canRentCar(ageOfTheDriver, classOfTheCar, yearsHoldingDriverLicence);

		double minRentalPrice = ageOfTheDriver;

		minRentalPrice = calculateMinRentalPrice(ageOfTheDriver, yearsHoldingDriverLicence, classOfTheCar, hasCausedAccidentsLastYear, highSeason, minRentalPrice);

		if (maxRentalPricePerDay(minRentalPrice)) return 1000.00;

		return minRentalPrice;
	}

	private double calculateMinRentalPrice(int ageOfTheDriver, int yearsHoldingDriverLicence, int classOfTheCar, boolean hasCausedAccidentsLastYear, boolean highSeason, double minRentalPrice) {

		if (classOfTheCar >=4 && ageOfTheDriver <= TWENTY_FIVE_YEARS && highSeason != false) {
			minRentalPrice = minRentalPrice * 2;
		}

		if (yearsHoldingDriverLicence < 3) {
			minRentalPrice = minRentalPrice * 1.3;
		}

		if (hasCausedAccidentsLastYear == true && ageOfTheDriver < THIRTY_YEARS) {
			minRentalPrice += PLUS_FIFTEEN_EURO;
		}
		return minRentalPrice;
	}

	private void canRentCar(int ageOfTheDriver, int classOfTheCar, int yearsHoldingDriverLicence) {

		if (ageOfTheDriver < EIGHTEEN_YEARS) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}

		if (ageOfTheDriver <= TWENTY_ONE_YEARS && classOfTheCar > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}

		if (yearsHoldingDriverLicence < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	private boolean maxRentalPricePerDay(double rentalPrice) {
		if (rentalPrice > MAX_RENT_PRICE) {
			return true;
		}
		return false;
	}
}
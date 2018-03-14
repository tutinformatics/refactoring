package rental;

public class RentalPriceCalculator {

	// age - age of driver
	// licence - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	public static double price(int age, int licence, int carClass, boolean acc, boolean season) {

		eligibleForRent(age, licence, carClass);
		return calculatePrice(age, licence, carClass, acc, season);

	}

	public static double calculatePrice(int age, int licence, int carClass, boolean acc, boolean season) {
		double rentalprice = age;

		if (highSeason(age, carClass, season)) {
			rentalprice = rentalprice * 2;
		}

		if (!longTerm(licence)) {
			rentalprice = rentalprice * 1.3;
		}

		if (accidents(age, acc)) {
			rentalprice += 15;
		}

		if (priceDeduction(rentalprice)) {
			return 1000.00;
		}
		return rentalprice;
	}

	public static boolean accidents(int age, boolean acc) {
		return acc && age < 30;
	}

	public static boolean longTerm(int licence) {
		return licence >= 3;
	}

	public static boolean highSeason(int age, int carClass, boolean season) {
		return carClass >=4 && age <= 25 && season;
	}

	public static boolean priceDeduction(double rentalprice) {
		return rentalprice > 1000;
	}

	public static void eligibleForRent(int age, int licence, int carClass) {
		agePermitControl(age, carClass);

		if (!atleastYear(licence)) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	public static boolean atleastYear(int licence) {
		return licence > 1;
	}

	public static void agePermitControl(int age, int carClass) {
		if (!isAdult(age)) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (ageForClass(age, carClass)) {
			throw new IllegalArgumentException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}

	public static boolean ageForClass(int age, int carClass) {
		return age <= 21 && carClass > 2;
	}

	public static boolean isAdult(int age) {
		return age > 18;
	}
}
package rental;

public class RentalPriceCalculator {
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	
	public double price(int age, int licence, int clazz, boolean acc, boolean season) {
		
		checkIfApplicable(age, clazz);
		
		double rentalprice = age;
		
		rentalprice = highSeasonPricing(age, clazz, season, rentalprice);
		
		rentalprice = checkLicense(licence, rentalprice);
		
		rentalprice = checkAccidents(age, acc, rentalprice);

		if (rentalprice > 1000) {
			return 1000.00;
		}
		return rentalprice;
	}

	public double highSeasonPricing(int age, int clazz, boolean season, double rentalprice) {
		if (clazz >=4 && age <= 25 && season == true) {
			rentalprice = rentalprice * 2;
		}
		return rentalprice;
	}

	public double checkAccidents(int age, boolean acc, double rentalprice) {
		if (acc == true && age < 30) {
			rentalprice += 15;
		}
		return rentalprice;
	}

	public double checkLicense(int licence, double rentalprice) {
		if (licence <= 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (licence <= 3) {
			rentalprice = rentalprice * 1.3;
		}
		return rentalprice;
	}

	public void checkIfApplicable(int age, int clazz) {
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (age <= 21 && clazz > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}
}
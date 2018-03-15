package rental;

public class RentalPriceCalculator {
	
	private final int MIN_AGE = 18;
	private final int MAX_RENTAL = 1000;
	private final int MIN_LICENSE_YEAR = 1;
	private final int YOUNG_DRIVER = 21;
	
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	public double calc_rental_price(int age, int licence_year, int car_to_rent, boolean caused_accidents, boolean season) {
		
		double rental_price = age;
		
		if (age < MIN_AGE) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (age <= YOUNG_DRIVER && car_to_rent > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		
		
		if (car_to_rent >=4 && age <= 25 && season != false) {
			rental_price = rental_price * 2;
		}
		
		if (licence_year < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (licence_year < 3) {
			rentalprice = rentalprice * 1.3;
		}
		
		if (caused_accidents == true && age < 30) {
			rentalprice += 15;
		}

		if (rentalprice > MAX_RENTAL) {
			return 1000.00;
		}
		return rentalprice;
	}
}
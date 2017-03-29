package rental;

public class RentalPriceCalculator {
	private double rentalprice;
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// accidentsCaused - has s/he caused any accidents within last year
	// season - if it is high season or not
	public double calculatePrice(int age, int licence, int clazz, boolean accidentsCaused, boolean season) {
		double rentalprice = age;
		
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}else if (age <= 21 && clazz > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}else if (licence < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}else if (clazz >=4 && age <= 25 && season == true) {
			rentalprice = rentalprice * 2;
		}else if (licence < 3) {
			rentalprice = rentalprice * 1.3;
		}else if (accidentsCaused == true && age < 30) {
			rentalprice += 15;
		}else if (rentalprice > 1000) {
			return 1000.00;
		}else{
			return rentalprice;
		}
		
	}
}
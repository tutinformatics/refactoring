package rental;

public class RentalPriceCalculator {
	
	// driversAge - age of driver
	// licenceForYears - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// causedAccidents - has s/he caused any accidents within last year
	// season - if it is high season or not
	public double calculatePrice(int driversAge, int licenceForYears, int carClass, boolean causedAccidents, boolean season) {
		double rentalPrice = driversAge;
		checkDriversSuitability(driversAge, licenceForYears);
		rentalPrice = getRentalPrice(driversAge, licenceForYears, carClass, causedAccidents, season);
		return rentalPrice:
	}
	
	public boolean checkDriversSuitability(int driversAge, int licenceForYears){
		if (driversAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (driversAge <= 21 && carClass > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		if (licenceForYears < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}
	
	public int getRentalPrice(int driversAge, int licenceForYears, int carClass, boolean causedAccidents, boolean season){
		if (carClass >=4 && driversAge <= 25 && season != false) {
			rentalprice = rentalprice * 2;
		}
		if (licenceForYears < 3) {
			rentalprice = rentalprice * 1.3;
		}
		if (causedAccidents == true && driversAge < 30) {
			rentalprice += 15;
		}
		if (rentalprice > 1000) {
			return 1000.00;
		}
		return rentalprice;
	}
}
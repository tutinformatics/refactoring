package rental;

public class RentalPriceCalculator {
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// lastYearAccidents - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// isHotSeasonTime - if it is high season or not
	
	//public double price(int age, int licence, int carClass, boolean acc, boolean acc2, boolean season) {

	double rentalprice;
	
	public double calculatePrice(int age, int carClass, int licence, boolean isHighSeasonTime, boolean lastYearAccidents) {
		if(isLegalToRent(age, licence, carClass)) {
			rentalprice = age;
		}
		
		applyPriceModifiers(rentalprice, licence, age, lastYearAccidents, carClass, isHighSeasonTime);
	
		if (rentalprice > 1000) {
			return 1000.00;
		} else {
			return rentalprice;
		}
	}
	
	public double applyPriceModifiers(double rentalprice, int licence, int age, boolean lastYearAccidents, int carClass, boolean isHighSeasonTime) {
		rentalprice = checkLicense(licence, rentalprice);
		rentalprice = checkAccidents(lastYearAccidents, age, rentalprice);
		rentalprice = adaptPriceByAge(rentalprice, age, carClass, isHighSeasonTime);
		return rentalprice;
	}
	
	public double adaptPriceByAge(double rentalprice, int age, int carClass, boolean isHighSeasonTime) {
		if (carClass >=4 && age <= 25 && isHighSeasonTime != false) {
			rentalprice = rentalprice * 2;
		}
		return rentalprice;
	}
	
	public boolean isLegalToRent(int age, int licence, int carClass) {
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (age <= 21 && carClass > 1) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		if (licence < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		return true;
	}
	
	public double checkLicense(int licence, double rentalprice) {
		if (licence < 3) {
			return rentalprice * 1.3;
		} else {
			return rentalprice;
		}
	}
	
	public double checkAccidents(boolean lastYearAccidents, int age, double rentalprice) {
		if (lastYearAccidents == true && age < 30) {
			return rentalprice + 15;
		} else {
			return rentalprice;
		}
	}
		
	
		
}
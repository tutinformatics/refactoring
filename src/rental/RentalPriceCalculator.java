package rental;

public class RentalPriceCalculator {
	
	private final int MIN_AGE = 18;
	private final int MAX_RENTAL = 1000;
	private final int MIN_LICENSE_YEAR = 1;
	private final int UNEXPERIENCED_DRIVER_AGE = 21;
	private final int EXPERIENCED_DRIVER_AGE = 30;
	

	public double calc_rental_price(int driverAge, int licence_year, int carToRent, boolean caused_accidents, boolean high_season) {
		
		double rentalPrice = driverAge;
		
		isAllowedToRent(driverAge,licence_year);
		unexperiencedDriverCar(driverAge,carToRent);
		rentalPrice = maximumPriceCalc(rentalPrice);
		rentalPrice = unExperiencedRenter(rentalPrice,licence_year);	
		rentalPrice= highSeasonPricing(driverAge, rentalPrice, carToRent, high_season);
		rentalPrice = riskyRent(rentalPrice,driverAge, caused_accidents);
		
		return rentalPrice;
		
	}
	private double highSeasonPricing(int driverAge,double rentalPrice, int carToRent, boolean high_season) {
		if (carToRent >=4 && driverAge <= 25 && high_season != false) {
			rentalPrice = rentalPrice * 2;
		}
		return rentalPrice;
	}
	private double unExperiencedRenter(double rentalPrice, int license_year) {
	
		if (license_year < 3) {
			rentalPrice = rentalPrice * 1.3;
		}
		return rentalPrice;
	}
		
	private double riskyRent(double rentalPrice, int driverAge,boolean caused_accidents) {
		if (caused_accidents == true && driverAge < EXPERIENCED_DRIVER_AGE) {
			rentalPrice += 15;
		}
		return rentalPrice;
	}
	

	private double maximumPriceCalc(double rentalPrice) {
		if (rentalPrice > MAX_RENTAL) {
			return 1000.00;
		}
		return rentalPrice;
	}

	private void unexperiencedDriverCar(int driverAge, int carToRent){
		if (driverAge <= UNEXPERIENCED_DRIVER_AGE && carToRent > 2) 
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
	}
	
	private void isAllowedToRent(int driverAge, int licence_year){
		if (driverAge < MIN_AGE){
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (licence_year < MIN_LICENSE_YEAR) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}
	
}
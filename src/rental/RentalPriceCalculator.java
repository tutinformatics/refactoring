package rental;

public class RentalPriceCalculator {
	private static final double MAX_RENTAL_PRICE = 1000.0;
	private static final int MINIMUM_YEARS_LICENSE_HELD = 1;
	private static final int DRIVER_AGE_CUTOFF = 18;

	public double price(RentalRequest request) throws InvalidRequestException
	{
		validateRequest(request);
		double rentalEstimate = getRentalEstimate(request);
		return getPriceFromEstimate(rentalEstimate);
	}

	void validateRequest(RentalRequest request) throws InvalidRequestException {
		if (!isDriverOldEnough(request)) {
			throw new InvalidRequestException(
				"Driver too young - cannot quote the price");
		}
		
		if (!hasLicenseBeenHeldLongEnough(request)) {
			throw new InvalidRequestException(
				"Driver has not held a license for long enough. Can not rent a car!");
		}
		
		if (!isVehicleAllowedForDriverAge(request)) {
			throw new InvalidRequestException(
				"The vehicle class is not suitable for the driver's age");
		}
	}

	boolean isDriverOldEnough(RentalRequest request) {
		return request.getDriverAge() >= DRIVER_AGE_CUTOFF;
	}

	boolean hasLicenseBeenHeldLongEnough(RentalRequest request) {
		return request.getYearsLicenseHeld() > MINIMUM_YEARS_LICENSE_HELD;
	}

	double getRentalEstimate(RentalRequest request) {
		double rentalEstimate = getInitialEstimate(request);
		
		rentalEstimate = adjustEstimateForSeason(rentalEstimate, request);
		rentalEstimate = adjustEstimateForLicenseHeld(rentalEstimate, request);
		rentalEstimate = adjustEstimateForAccidentStatus(rentalEstimate, request);
		
		return rentalEstimate;
	}

	double getInitialEstimate(RentalRequest request) {
		return request.getDriverAge();
	}

	double adjustEstimateForSeason(double rentalEstimate, RentalRequest request)
	{
		VehicleClass vehicleClass = request.getVehicleClass();
		
		if ((vehicleClass == VehicleClass.FOURTH_CLASS ||  vehicleClass == VehicleClass.FIFTH_CLASS)
			&& request.getDriverAge() <= 25 
			&& !request.isHighSeason()) {
			rentalEstimate = rentalEstimate * 2;
		}
		
		return rentalEstimate;
	}

	double adjustEstimateForLicenseHeld(double rentalEstimate, RentalRequest request) {
		if (request.getYearsLicenseHeld() < 3) {
			rentalEstimate = rentalEstimate * 1.3;
		}
		
		return rentalEstimate;
	}

	double adjustEstimateForAccidentStatus(double rentalEstimate, RentalRequest request) {
		if (request.hasCausedAccidentsWithinLastYear()
			&& request.getDriverAge() < 30) {
			rentalEstimate += 15;
		}
		
		return rentalEstimate;
	}

	boolean isVehicleAllowedForDriverAge(RentalRequest request) {
		if (request.getDriverAge() <= 21) {
			return request.getVehicleClass() == VehicleClass.FIRST_CLASS;
		}
		
		return true;
	}

	double getPriceFromEstimate(double rentalEstimate) {
		return Math.min(rentalEstimate, MAX_RENTAL_PRICE);
	}
}
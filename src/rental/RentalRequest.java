package rental;

public class RentalRequest {
	private int driverAge;
	private int yearsLicenseHeld;
	private VehicleClass vehicleClass;
	private boolean hasCausedAccidentsWithinLastYear;
	private boolean hasParticipatedInAccidentsWithinLastYear;
	private boolean isHighSeason;
	
	public int getDriverAge() {
		return driverAge;
	}

	public int getYearsLicenseHeld() {
		return yearsLicenseHeld;
	}

	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	public boolean hasCausedAccidentsWithinLastYear() {
		return hasCausedAccidentsWithinLastYear;
	}

	public boolean hasParticipatedInAccidentsWithinLastYear() {
		return hasParticipatedInAccidentsWithinLastYear;
	}

	public void hasParticipatedInAccidentsWithinLastYear(
		boolean hasParticipatedInAccidentsWithinLastYear) {
		this.hasParticipatedInAccidentsWithinLastYear = hasParticipatedInAccidentsWithinLastYear;
	}

	public boolean isHighSeason() {
		return isHighSeason;
	}

	public RentalRequest(
			int driverAge, 
			int yearsLicenseHeld, 
			VehicleClass vehicleClass,
			boolean hasCausedAccidentsWithinLastYear, 
			boolean hasParticipatedInAccidentsWithinLastYear,
			boolean isHighSeason) {
		super();
		this.driverAge = driverAge;
		this.yearsLicenseHeld = yearsLicenseHeld;
		this.vehicleClass = vehicleClass;
		this.hasCausedAccidentsWithinLastYear = hasCausedAccidentsWithinLastYear;
		this.hasParticipatedInAccidentsWithinLastYear = hasParticipatedInAccidentsWithinLastYear;
		this.isHighSeason = isHighSeason;
	}
}

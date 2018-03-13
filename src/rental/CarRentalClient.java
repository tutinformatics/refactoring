package rental;

/**
 * Class representing a client in the car rental system.
 */
class CarRentalClient {

    /**
     * Age of the client in years.
     */
    private final int age;

    /**
     *
     */
    private final int numberOfDaysHoldingLicense;

    /**
     *
     */
    private final boolean hasCausedAccidentsRecently;

    /**
     *
     * @param age
     * @param numberOfDaysHoldingLicense
     * @param hasCausedAccidentsRecently
     */
    CarRentalClient(int age,
                    int numberOfDaysHoldingLicense,
                    boolean hasCausedAccidentsRecently) {

        this.age = age;
        this.numberOfDaysHoldingLicense = numberOfDaysHoldingLicense;
        this.hasCausedAccidentsRecently = hasCausedAccidentsRecently;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public int getNumberOfDaysHoldingLicense() {
        return numberOfDaysHoldingLicense;
    }

    /**
     *
     * @return
     */
    public boolean hasCausedAccidentsRecently() {
        return hasCausedAccidentsRecently;
    }

}

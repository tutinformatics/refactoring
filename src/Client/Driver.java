package Client;

public class Driver {

    private boolean hasCausedAccident; //has s/he caused any accidents within last year
    private boolean isInvolvedAccident; // has s/he participated (but not caused) in any accidents within last year
    private int age; // age of driver
    private int licenceAge; //number of full years person holds driving licence


    public Driver(boolean hasCausedAccident, boolean isInvolvedAccident, int age, int licenceAge) {
        this.hasCausedAccident = hasCausedAccident;
        this.isInvolvedAccident = isInvolvedAccident;
        this.age = age;
        this.licenceAge = licenceAge;
    }

    public boolean isCausedAccident() {
        return hasCausedAccident;
    }

    public boolean isInvolvedAccident() {
        return isInvolvedAccident;
    }

    public int getAge() {
        return age;
    }

    public int getLicenceAge() {
        return licenceAge;
    }
}

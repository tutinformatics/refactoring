package rental;

public class Car {

    private int sizeClass; // class of the car from 1 (smallest) to 5 (largest) that person wishes to rent

    public Car(int sizeClass) {
        this.sizeClass = sizeClass;
    }

    public int getSizeClass() {
        return sizeClass;
    }
}

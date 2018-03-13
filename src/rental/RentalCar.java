package rental;

/**
 * Class representing a rental car in the car rental system.
 */
class RentalCar {

    static final int CLASS_CATEGORY_LOWEST = 1;
    static final int CLASS_CATEGORY_LOW = 2;
    static final int CLASS_CATEGORY_MEDIUM = 3;
    static final int CLASS_CATEGORY_HIGH = 4;
    static final int CLASS_CATEGORY_HIGHEST = 5;

    /**
     *
     */
    private final int classCategory;

    /**
     *
     * @param classCategory
     */
    RentalCar(int classCategory) throws Exception {
        if (CLASS_CATEGORY_LOWEST <= classCategory && classCategory <= CLASS_CATEGORY_HIGHEST) {
            this.classCategory = classCategory;
        } else {
            throw new Exception("Invalid class category");
        }
    }

    public int getClassCategory() {
        return classCategory;
    }
}

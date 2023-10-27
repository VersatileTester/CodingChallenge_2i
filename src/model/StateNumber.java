package model;

/** !DesignChoice:
 * model.StateNumber class to represent a number AND it's state (whether it is available to be paired or not).
 * This object was created to bypass the immutability of arrays.
 *
 */
public class StateNumber {
    /** The 'number' property has a getter, because after creation of a model.StateNumber object, it should be immutable. */
    private int number;
    /** The 'active' property has a getter and setter, because it will need to be updated when it has been used. */
    private boolean active;

    public int getNumber() {
        return number;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    /** !DesignChoice:
     * The constructor only takes a number because we know that if the model.StateNumber object is active until it is used,
     * hence active is always true when creating the object.
     */
    public StateNumber(int number){
        this.number = number;
        this.active = true;
    }
}

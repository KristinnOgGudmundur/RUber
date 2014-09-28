package is.ru.honn.ruber.domain;

/**
 * Contains available values for the status of a trip
 */
public enum TripStatus {
	/**
	 * Signifies that the trip is completed
	 */
    COMPLETED(1);

    protected final int value;

    private TripStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return values()[value].toString();
    }
}

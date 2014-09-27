package is.ru.honn.ruber.domain;

/**
 * Created by Kristinn on 26.9.2014.
 */
public enum TripStatus {
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

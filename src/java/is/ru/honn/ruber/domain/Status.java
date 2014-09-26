package is.ru.honn.ruber.domain;

/**
 * Created by Kristinn on 26.9.2014.
 */
public enum Status {
    COMPLETED(1);

    protected final int value;

    private Status(int value) {
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

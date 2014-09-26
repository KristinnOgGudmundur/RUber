package is.ru.honn.ruber.domain;

import java.util.List;

/**
 * Created by Kristinn on 26.9.2014.
 */
public class History {
    protected int offset;
    protected int limit;
    protected int count;
    protected List<Trip> history;

    public History() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Trip> getHistory() {
        return history;
    }

    public void setHistory(List<Trip> history) {
        this.history = history;
    }
}

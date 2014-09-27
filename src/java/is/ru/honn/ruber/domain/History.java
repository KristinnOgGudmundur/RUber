package is.ru.honn.ruber.domain;

import java.util.ArrayList;
import java.util.List;

//TODO: Learn what this class does and how it is related to User and Trip
public class History {
    protected int offset;
    protected int limit;
    protected int count;
    protected List<Trip> history;

    public History() {
    }

	public History(int offset, int limit, int count){
		setOffset(offset);
		setLimit(limit);
		setCount(count);
		history = new ArrayList<Trip>();
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

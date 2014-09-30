package is.ru.honn.ruber.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A POJO class containing information about a user's trip history
 */
public class History {
	/**
	 * Position in pagination.
	 */
    protected int offset;
	/**
	 * Number of items to retrieve (100 max)
	 */
    protected int limit;
	/**
	 * Total number of items available
	 */
    protected int count;
	/**
	 * A list of all the trips that the user has taken
	 */
    protected List<Trip> history;

	/**
	 * A default constructor. Instantiates history
	 */
    public History() {
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

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("Count: " + getCount() + "\n" +
                       "Limit: " + getLimit() + "\n" +
                       "Offset: " + getOffset() + "\n");

        for(Trip t : getHistory())
        {
            builder.append("Trip{" + "\n" + t.toString() + "}" + "\n\n");
        }

        return builder.toString();
    }
}

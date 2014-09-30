package is.ru.honn.ruber.domain;

/**
 * A POJO class that contains information about a trip
 */
public class Trip {
	/**
	 * The id of the User that bought the trip
	 */
    protected String uuid;
	/**
	 * The time when the trip was requested
	 */
    protected int requestTime;
	/**
	 * The id of the trip's product
	 */
    protected String productId;
	/**
	 * The status of the trip
	 */
    protected TripStatus status;
	/**
	 * The distance of the trip
	 */
    protected float distance;
	/**
	 * The time when the trip started
	 */
    protected int startTime;
	/**
	 * The time when the trip ended
	 */
    protected int endTime;

	/**
	 * A default constructor
	 */
    public Trip() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(int requestTime) {
        this.requestTime = requestTime;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Uuid: " + getUuid() + "\n" +
               "Product Id: " + getProductId() + "\n" +
               "Distance: " + getDistance() + "\n" +
               "Start time" + getStartTime() + "\n" +
               "End time: " + getEndTime() + "\n" +
               "Request time: " + getRequestTime() + "\n" +
               "Status: " + getStatus().name() + "\n";
    }
}

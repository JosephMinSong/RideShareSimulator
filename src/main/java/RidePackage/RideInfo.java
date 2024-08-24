package RidePackage;

/**
 * RideInfo is a concrete class that represents the basic information about a ride
 */
public class RideInfo {
  private Integer customerID;
  private String startingLocation;
  private String desiredLocation;
  private Double rideDistance;
  private Integer timeRequested;
  private Integer priority;

  /**
   * Constructor for RideInfo
   * @param customerID        Integer representing the customer ID
   * @param startingLocation  String representing the starting location of the ride
   * @param desiredLocation   String representing the ending location of the ride
   * @param rideDistance      Double representing the ride distance of this ride
   * @param timeRequested     Integer representing the time requested for this ride
   * @param priority          Integer representing the priority status of this ride
   */
  public RideInfo(Integer customerID, String startingLocation, String desiredLocation,
      Double rideDistance, Integer timeRequested, Integer priority) {
    this.customerID = customerID;
    this.startingLocation = startingLocation;
    this.desiredLocation = desiredLocation;
    this.rideDistance = rideDistance;
    this.timeRequested = timeRequested;
    this.priority = priority;
  }

  /**
   * Getter for customer ID
   * @return Integer representing the customer ID
   */
  public Integer getCustomerID() {
    return customerID;
  }

  /**
   * Getter for starting location
   * @return String representing the starting location of the ride
   */
  public String getStartingLocation() {
    return startingLocation;
  }

  /**
   * Getter for ending location
   * @return String representing the ending location of the ride
   */
  public String getDesiredLocation() {
    return desiredLocation;
  }

  /**
   * Getter for ride distance
   * @return Double representing the distance of this ride
   */
  public Double getRideDistance() {
    return rideDistance;
  }

  /**
   * Getter for the time requested for this ride
   * @return Integer representing the requested time in minutes
   */
  public Integer getTimeRequested() {
    return timeRequested;
  }

  /**
   * Getter for priority of this ride as an Integer
   * @return Integer representing the priority status of this ride
   */
  public Integer getPriority(){
    return this.priority;
  }

  /**
   * {inheritDoc}
   */
  @Override
  public String toString() {
    return "RideInfo{" +
        "customerID=" + customerID +
        ", startingLocation='" + startingLocation + '\'' +
        ", desiredLocation='" + desiredLocation + '\'' +
        ", rideDistance=" + rideDistance +
        ", timeRequested=" + timeRequested +
        ", priority=" + priority +
        '}';
  }
}

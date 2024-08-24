package RidePackage;

/**
 * CompletedRide is a concrete class representing a ride that has been completed
 */
public class CompletedRide {
  private RideInfo ride;
  private Integer actualStartTime;
  private Integer endTime;
  private Integer driverId;
  private Integer timeWaited;

  /**
   * Constructor for CompletedRide
   * @param ride            RideInfo representing the basic information of this ride
   * @param actualStartTime Integer representing the start time of this ride
   * @param endTime         Integer representing the end time of this ride
   * @param driverId        Integer representing the driver ID for this ride
   * @param timeWaited      Integer representing how long this rider waited
   */
  public CompletedRide(RideInfo ride, Integer actualStartTime, Integer endTime, Integer driverId, Integer timeWaited) {
    this.ride = ride;
    this.actualStartTime = actualStartTime;
    this.endTime = endTime;
    this.driverId = driverId;
    this.timeWaited = timeWaited;
  }

  /**
   * Getter for ride info
   * @return
   */
  public RideInfo getRide() {
    return ride;
  }

  /**
   * Getter for start time
   * @return Integer representing the start time
   */
  public Integer getActualStartTime(){
    return this.actualStartTime;
  }

  /**
   * Getter for end time
   * @return Integer representing the end time
   */
  public Integer getEndTime() {
    return endTime;
  }

  /**
   * Getter for driver id
   * @return Integer representing the driver id
   */
  public Integer getDriverId() {
    return driverId;
  }

  /**
   * Getter for time waited
   * @return Integer representing the time waited by the rider in minutes
   */
  public Integer getTimeWaited() {
    return timeWaited;
  }
}

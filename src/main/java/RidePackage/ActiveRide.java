package RidePackage;

import DriverPackage.Driver;

/**
 * ActiveRide is a concrete class that represents an ongoing active ride in the simulation
 */
public class ActiveRide{
  // Static final variables
  private static final Integer AVG_SPEED = 60;
  private static final Integer SIXTY = 60;

  // Private fields
  private RideInfo ride;
  private Integer actualStartTime;
  private Integer endTime;
  private Driver driver;

  /**
   * Constructor for Active Ride
   * @param ride    RideInfo representing the basic information about the ride
   * @param start   Integer representing the start time of the ride
   * @param driver  Driver representing the driver assigned to this active ride
   */
  public ActiveRide(RideInfo ride, Integer start, Driver driver) {
    this.ride = ride;
    this.driver = driver;
    // Detail: Actual start time is when the ride actually starts, not when the rider requests it - this is because there may be a waiting period
    this.actualStartTime = start;
    // Detail: End time is calculated via distance given and an average speed of 60mph
    this.endTime = this.calculateEndTime();
  }

  /**
   * Getter for ride information
   * @return RideInfo representing the information about this ride
   */
  public RideInfo getRide() {
    return ride;
  }

  /**
   * Getter for the start time for this ride
   * @return Integer representing the start time of this ride in minutes
   */
  public Integer getActualStartTime() {
    return actualStartTime;
  }

  /**
   * Method to calculate the travel time of this ride
   * @return Integer representing the minutes that this ride will take on average
   */
  public Integer calculateTravelTime(){
    return this.ride.getRideDistance().intValue();
  }

  /**
   * Method to calculate when this ride will end based on the average travel time
   * @return Integer representing the end time of this ride
   */
  public Integer calculateEndTime(){
    Integer travelTime = this.calculateTravelTime();
    return this.actualStartTime + travelTime;
  }

  /**
   * Getter for the end time of this ride
   * @return Integer representing the end time of this ride
   */
  public Integer getEndTime(){
    return this.endTime;
  }

  /**
   * Getter for the Driver of this ride
   * @return Driver representing the Driver of this ride
   */
  public Driver getDriver(){
    return this.driver;
  }

  /**
   * Method to calculate how long this rider has been waiting to be picked up
   * @return Integer representing how long the rider waited for a ride
   */
  public Integer calculateTimeWaited(){
    Integer timeWaited = this.actualStartTime - this.ride.getTimeRequested();
    if (timeWaited < 0){
      timeWaited = 0;
    }
    return timeWaited;
  }

  /**
   * {inheritDoc}
   */
  @Override
  public String toString() {
    return "ActiveRide{" +
        "ride=" + ride +
        ", actualStartTime=" + actualStartTime +
        ", endTime=" + endTime +
        ", driver=" + driver +
        '}';
  }
}

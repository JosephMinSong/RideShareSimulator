package RidePackage;

import UtilityPackage.ConversionUtility;

/**
 * RequestedRide is a concrete class that represents a requested ride from a user
 */
public class RequestedRide {
  // Static final variables
  private static final Integer EXPRESS_PRIORITY = 5;
  private static final Integer STANDARD_PRIORITY = 3;
  private static final Integer WAIT_PRIORITY = 1;

  private RideInfo ride;
  private RideType rideType;

  /**
   * Constructor for RequestedRide
   * @param ride  RideInfo representing the ride information
   */
  public RequestedRide(RideInfo ride) {
    this.ride = ride;
    this.rideType = ConversionUtility.convertPriortyFromInteger(this.ride.getPriority());
  }

  /**
   * Getter for ride information
   * @return RideInfo representing the ride information
   */
  public RideInfo getRide() {
    return ride;
  }

  /**
   * Getter for RideType - priority status
   * @return RideType Enum representing the priority status
   */
  public RideType getRideType() {
    return rideType;
  }

  /**
   * Getter for priority of this ride
   * @return Integer representing the integer priority status equivalence
   */
  public Integer getPriority(){
    return this.ride.getPriority();
  }

  /**
   * Method to determine the time dispatch should consider this ride based on priority
   * @return Integer representing the priority time
   */
  public Integer getPriorityTime(){
    Integer t = this.ride.getTimeRequested();
    Integer subtractedPriority = switch(this.getRideType()) {
      case EXPRESS -> t - EXPRESS_PRIORITY;
      case STANDARD -> t - STANDARD_PRIORITY;
      case WAIT_AND_SAVE -> t - WAIT_PRIORITY;
      default -> t;
    };
    return subtractedPriority;
  }

  /**
   * {inheritDoc}
   */
  @Override
  public String toString() {
    return "RequestedRide{" +
        "ride=" + ride +
        ", rideType=" + rideType +
        '}';
  }
}

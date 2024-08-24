package UIPackage;

import ObserverPackage.Observer;
import RidePackage.ActiveRide;
import RidePackage.RequestedRide;
import UtilityPackage.ConversionUtility;

/**
 * UserInterface is a concrete class that implements a custom Observer interface
 */
public class UserInterface implements Observer {

  /**
   * Constructor for UserInterface
   */
  public UserInterface() {
  }

  /**
   * Private method to print a delimiter for easier to read print statements
   */
  private void printDelimiter() {
    System.out.println("*".repeat(15));
  }

  /**
   * Method to update the user of a ride that has been started
   * @param ride ActiveRide representing the ride to start
   */
  @Override
  public void updateUserStartRide(ActiveRide ride) {
    String pickupTime = ConversionUtility.convertTimeToString(ride.getActualStartTime());
    this.printDelimiter();
    System.out.println("Hey, " + ride.getRide().getCustomerID());
    System.out.println("A driver has been assigned to pick you up at: " + pickupTime);
    System.out.println("Your driver id is: " + ride.getDriver().getDriverId());
    this.printDelimiter();
  }

  /**
   * Method to update the user of a ride that has been completed
   * @param ride ActiveRide representing the completed ride
   */
  @Override
  public void updateUserEndRide(ActiveRide ride) {
    String endTime = ConversionUtility.convertTimeToString(ride.getEndTime());
    this.printDelimiter();
    System.out.println("Thank you for choosing Joe Schmo's Riding Service!");
    System.out.println("Your id: " + ride.getRide().getCustomerID());
    System.out.println("You were dropped off at: " + endTime);
    System.out.println("Your ride was approximately: " + ride.calculateTravelTime() + " minutes");
    this.printDelimiter();
  }
}

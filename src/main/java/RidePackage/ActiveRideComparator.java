package RidePackage;

import java.util.Comparator;

/**
 * ActiveRideComparator is a Comparator class that is to be used to compare two ActiveRides
 */
public class ActiveRideComparator implements Comparator<ActiveRide> {

  /**
   * Constructor for ActiveRideComparator
   */
  public ActiveRideComparator() {
  }

  /**
   * Method to compare two active rides
   * - Active rides will be compared based on their end times
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return int representing the result of the comparison
   */
  @Override
  public int compare(ActiveRide o1, ActiveRide o2) {
    return Integer.compare(o1.getEndTime(), o2.getEndTime());
  }
}

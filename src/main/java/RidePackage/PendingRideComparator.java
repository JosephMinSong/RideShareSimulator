package RidePackage;

import java.util.Comparator;

/**
 * PendingRideComparator is a Comparator class that used to compare two pending rides
 */
public class PendingRideComparator implements Comparator<RequestedRide> {

  /**
   * Method to compare two pending rides
   * - Pending rides will be compared based on their priority status
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return int representing the result of the comparison
   */
  @Override
  public int compare(RequestedRide o1, RequestedRide o2) {
    return Integer.compare(o1.getRide().getPriority(), o2.getRide().getPriority());
  }
}

package RidePackage;

import java.util.Comparator;

/**
 * RequestRideComparator is a Comparator class used to compare two Requested Rides
 */
public class RequestRideComparator implements Comparator<RequestedRide> {

  /**
   * Constructor for RequestRideComparator
   */
  public RequestRideComparator() {
  }

  /**
   * Method to compare two RequestedRides
   * - They will first be compared based on priority time
   * - If those are equal, they will be compared based on priority status
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return int representing the result of the comparison
   */
  @Override
  public int compare(RequestedRide o1, RequestedRide o2) {
    int comp = Integer.compare(o1.getPriorityTime(), o2.getPriorityTime());
    if (comp != 0){
      return comp;
    } else {
      return Integer.compare(o1.getPriority(), o2.getPriority());
    }
  }
}

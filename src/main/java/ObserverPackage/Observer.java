package ObserverPackage;

import RidePackage.ActiveRide;
import RidePackage.RequestedRide;

/**
 * Observer is a custom Observer for our simulation to update the user upon events
 */
public interface Observer {
  void updateUserStartRide(ActiveRide ride);
  void updateUserEndRide(ActiveRide ride);
}

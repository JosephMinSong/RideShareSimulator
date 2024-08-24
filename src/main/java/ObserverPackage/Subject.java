package ObserverPackage;

import ObserverPackage.Observer;
import RidePackage.ActiveRide;
import RidePackage.RequestedRide;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyUserStartRide(ActiveRide ride);
    void notifyUserEndRide(ActiveRide ride);
}

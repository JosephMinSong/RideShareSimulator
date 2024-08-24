package RidePackage;

import static org.junit.jupiter.api.Assertions.*;

import DriverPackage.Driver;
import com.sun.net.httpserver.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PendingRideComparatorTest {
  private RideInfo ride1Info;
  private RideInfo ride2Info;
  private RequestedRide requestedRide1;
  private RequestedRide requestedRide2;
  private PendingRideComparator comparator;

  @BeforeEach
  void setUp() {
    ride1Info = new RideInfo(1, "start", "end", 10.0, 100, 1);
    ride2Info = new RideInfo(2, "start", "end", 11.0, 100, 2);
    requestedRide1 = new RequestedRide(ride1Info);
    requestedRide2 = new RequestedRide(ride2Info);
    comparator = new PendingRideComparator();
  }

  @Test
  void compare() {
    assertEquals(-1, comparator.compare(requestedRide1, requestedRide2));
  }
}
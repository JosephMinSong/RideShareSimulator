package RidePackage;

import static org.junit.jupiter.api.Assertions.*;

import DriverPackage.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActiveRideComparatorTest {
  private RideInfo ride1Info;
  private RideInfo ride2Info;
  private Driver driver1;
  private Driver driver2;
  private Integer start1;
  private Integer start2;
  private ActiveRide activeRide1;
  private ActiveRide activeRide2;
  private ActiveRideComparator comparator;

  @BeforeEach
  void setUp() {
    ride1Info = new RideInfo(1, "start", "end", 10.0, 100, 1);
    ride2Info = new RideInfo(2, "start", "end", 11.0, 100, 1);
    driver1 = new Driver(1);
    driver2 = new Driver(2);
    start1 = 1500;
    start2 = 1500;
    activeRide1 = new ActiveRide(ride1Info, start1, driver1);
    activeRide2 = new ActiveRide(ride2Info, start2, driver2);
    comparator = new ActiveRideComparator();
  }

  @Test
  void compare() {
    assertEquals(-1, comparator.compare(activeRide1, activeRide2));
  }
}
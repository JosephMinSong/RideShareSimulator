package RidePackage;

import static org.junit.jupiter.api.Assertions.*;

import DriverPackage.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompletedRideTest {
  private RideInfo expectedRide;
  private Integer expectedStartTime;
  private Integer expectedEndTime;
  private Integer expectedDriverID;
  private Integer expectedTimeWaited;
  private CompletedRide testCompletedRide;

  @BeforeEach
  void setUp() {
    expectedRide = new RideInfo(1, "start", "end", 10.0, 100, 1);
    expectedStartTime = 500;
    expectedEndTime = 510;
    expectedDriverID = 1;
    expectedTimeWaited = 10;
    testCompletedRide = new CompletedRide(expectedRide, expectedStartTime, expectedEndTime, expectedDriverID, expectedTimeWaited);
  }

  @Test
  void getRide() {
    assertEquals(expectedRide, testCompletedRide.getRide());
  }

  @Test
  void getActualStartTime() {
    assertEquals(expectedStartTime, testCompletedRide.getActualStartTime());
  }

  @Test
  void getEndTime() {
    assertEquals(expectedEndTime, testCompletedRide.getEndTime());
  }

  @Test
  void getDriverId() {
    assertEquals(expectedDriverID, testCompletedRide.getDriverId());
  }

  @Test
  void getTimeWaited() {
    assertEquals(expectedTimeWaited, testCompletedRide.getTimeWaited());
  }
}
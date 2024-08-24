package RidePackage;

import static org.junit.jupiter.api.Assertions.*;

import DriverPackage.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActiveRideTest {
  private RideInfo expectedRide;
  private Integer expectedStartTime;
  private Driver expectedDriver;
  private ActiveRide testDrive;

  @BeforeEach
  void setUp() {
    expectedRide = new RideInfo(1, "start", "end", 10.0, 100, 1);
    expectedStartTime = 100;
    expectedDriver = new Driver(1);
    testDrive = new ActiveRide(expectedRide, expectedStartTime, expectedDriver);
  }

  @Test
  void getRide() {
    assertEquals(expectedRide, testDrive.getRide());
  }

  @Test
  void getActualStartTime() {
    assertEquals(expectedStartTime, testDrive.getActualStartTime());
  }

  @Test
  void calculateTravelTime() {
    Integer travelTime = expectedRide.getRideDistance().intValue();
    assertEquals(travelTime, testDrive.calculateTravelTime());
  }

  @Test
  void calculateEndTime() {
    Integer travelTime = expectedRide.getRideDistance().intValue();
    Integer endtime = expectedStartTime + travelTime;
    assertEquals(endtime, testDrive.calculateEndTime());
  }

  @Test
  void getEndTime() {
    Integer travelTime = expectedRide.getRideDistance().intValue();
    Integer endtime = expectedStartTime + travelTime;
    assertEquals(endtime, testDrive.getEndTime());
  }

  @Test
  void getDriver() {
    assertEquals(expectedDriver, testDrive.getDriver());
  }

  @Test
  void calculateTimeWaited() {
    assertEquals(0, testDrive.calculateTimeWaited());
  }

  @Test
  void testToString() {
    String expectedString = "ActiveRide{" +
        "ride=" + testDrive.getRide() +
        ", actualStartTime=" + testDrive.getActualStartTime() +
        ", endTime=" + testDrive.getEndTime() +
        ", driver=" + testDrive.getDriver() +
        '}';
    assertEquals(expectedString, testDrive.toString());
  }
}
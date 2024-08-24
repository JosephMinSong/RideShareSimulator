package DriverPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {
  private Integer expectedDriverID;
  private Driver testDriver;

  @BeforeEach
  void setUp() {
    expectedDriverID = 1;
    testDriver = new Driver(expectedDriverID);
  }

  @Test
  void getDriverId() {
    assertEquals(expectedDriverID, testDriver.getDriverId());
  }

  @Test
  void getNumDrives() {
    assertEquals(0, testDriver.getNumDrives());
  }

  @Test
  void addRide() {
    testDriver.addRide();
    assertEquals(1, testDriver.getNumDrives());
  }
}
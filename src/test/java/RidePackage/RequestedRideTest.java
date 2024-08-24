package RidePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestedRideTest {
  private RideInfo ride1;
  private RideInfo ride2;
  private RequestedRide testRide1;
  private RequestedRide testRide2;

  @BeforeEach
  void setUp() {
    ride1 = new RideInfo(1, "start1", "end1", 10.0, 500, 1);
    ride2 = new RideInfo(2, "start2", "end2", 10.0, 500, 2);
    testRide1 = new RequestedRide(ride1);
    testRide2 = new RequestedRide(ride2);
  }

  @Test
  void getRide() {
    assertEquals(ride1, testRide1.getRide());
    assertEquals(ride2, testRide2.getRide());
  }

  @Test
  void getRideType() {
    assertEquals(RideType.EXPRESS, testRide1.getRideType());
    assertEquals(RideType.STANDARD, testRide2.getRideType());
  }

  @Test
  void getPriority() {
    assertEquals(1, testRide1.getPriority());
    assertEquals(2, testRide2.getPriority());
  }

  @Test
  void getPriorityTime() {
    Integer priorityTime1 = testRide1.getRide().getTimeRequested() - 5;
    Integer priorityTime2 = testRide2.getRide().getTimeRequested() - 3;
    assertEquals(priorityTime1, testRide1.getPriorityTime());
    assertEquals(priorityTime2, testRide2.getPriorityTime());
  }

  @Test
  void testToString() {
    String expectedString = "RequestedRide{" +
        "ride=" + testRide1.getRide() +
        ", rideType=" + testRide1.getRideType() +
        '}';
    assertEquals(expectedString, testRide1.toString());
  }
}
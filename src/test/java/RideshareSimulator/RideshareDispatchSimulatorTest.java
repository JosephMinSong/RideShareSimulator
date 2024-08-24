package RideshareSimulator;

import static org.junit.jupiter.api.Assertions.*;

import UIPackage.UserInterface;
import UtilityPackage.ConversionUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideshareDispatchSimulatorTest {
  private Integer expectedNumDrivers;
  private Integer expectedNumRides;
  private String expectedStartTime;
  private String expectedEndTime;
  private UserInterface ui;
  private RideshareDispatchSimulator simulator;

  @BeforeEach
  void setUp() {
    expectedNumDrivers = 20;
    expectedNumRides = 150;
    expectedStartTime = "08:00";
    expectedEndTime = "15:00";
    ui = new UserInterface();
    try{
      simulator = new RideshareDispatchSimulator(expectedNumDrivers, expectedNumRides, expectedStartTime, expectedEndTime);
      simulator.addObserver(ui);
    } catch (RDSException e){
      System.out.println(e);
    }
  }

  @Test
  void runSimulation() {
    simulator.runSimulation();

    // Codewalk: Test all fields
    assertEquals(expectedNumDrivers, simulator.getNumDrivers());
    assertEquals(expectedNumRides, simulator.getNumRides());
    Integer start = ConversionUtility.convertTimeToInteger(expectedStartTime);
    Integer end = ConversionUtility.convertTimeToInteger(expectedEndTime);
    assertEquals(start, simulator.getStartTime());
    assertEquals(end, simulator.getEndTime());

    // Codewalk: All available drivers at the end of the simulation should be available
    // and equal to the initial number of drivers
    assertEquals(expectedNumDrivers, simulator.getAvailableDrivers().size());

    // Codewalk: All completed rides length should equal the number of rides the user inputted
    assertEquals(expectedNumRides, simulator.getAllCompletedRides().size());
  }
}
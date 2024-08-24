package DriverPackage;

/**
 * Driver is a concrete class that represents a Driver within our simulation
 */
public class Driver {
  private Integer driverId;
  private Integer numDrives;

  /**
   * Constructor for Driver
   * @param driverId  Integer representing the driver's ID
   */
  public Driver(Integer driverId) {
    this.driverId = driverId;
    this.numDrives = 0;
  }

  /**
   * Getter for driver ID
   * @return Integer representing the driver's ID
   */
  public Integer getDriverId(){
    return this.driverId;
  }

  /**
   * Getter for number of drives that this driver has done
   * @return Integer representing the number of drives this driver has done
   */
  public Integer getNumDrives() {
    return this.numDrives;
  }

  /**
   * Method to add a ride to this driver's count
   */
  public void addRide(){
    this.numDrives++;
  }
}

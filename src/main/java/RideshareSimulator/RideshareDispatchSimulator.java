package RideshareSimulator;

import DriverPackage.Driver;
import ObserverPackage.Subject;
import ObserverPackage.Observer;
import RandomPackage.Random;
import RidePackage.ActiveRide;
import RidePackage.ActiveRideComparator;
import RidePackage.CompletedRide;
import RidePackage.PendingRideComparator;
import RidePackage.RequestRideComparator;
import RidePackage.RequestedRide;
import RidePackage.RideInfo;
import UtilityPackage.ConversionUtility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * RideshareDispatchSimulator is a concrete class that implements Subject
 * It is meant to simulate a dispatching center for a riding service like Uber or Lyft
 * Subject is an Observer design - the dispatching service is being observed by a User Interface
 * The User Interface is updated every time a ride is either assigned or completed, informing the user - much like Uber or Lyft would
 * It's main functionality is to do the following:
 * - Generate data based on inputted arguments (number of driver, number of rides, start time, end time)
 * - Run the simulation with the generated data within the time frame
 * - Output all completed rides and an analysis of the simulation (average wait time, average number of drives per driver)
 */
public class RideshareDispatchSimulator implements Subject {
  // Static final variables
  private static final Integer ZERO = 0;
  private static final Integer MINUTES_IN_DAY = 1440;
  private static final String[] RANDOM_LOCATIONS = {"Location A", "Location B", "Location C", "Location D", "Location E",
      "Location F", "Location G"};
  private static final Double DISTANCE_LOWER_BOUND = 15.0;
  private static final Double DISTANCE_UPPER_BOUND = 45.0;
  private static final Integer PRIORITY_BOUND = 4;
  private static final File OUTPUT_FILE = new File("C:\\Users\\songj\\OneDrive\\Documents\\cs5004\\Student_repo_Joseph_Joe_Song\\FinalProject\\src\\main\\java\\results.csv");

  // Private fields
  private Integer numDrivers;
  private Integer numRides;
  private Integer startTime;
  private Integer endTime;


  // Data structures
  // Detail: All requested rides will be sorted via priority start time, then by priority
  private PriorityQueue<RequestedRide> allRequestedRides;

  // Detail: All active rides will be sorted via end time - once an active ride is done, the driver will be added back into the available drivers queue
  private PriorityQueue<ActiveRide> allActiveRides;

  // Detail: All pending rides will be sorted via priority
  private PriorityQueue<RequestedRide> allPendingRides;

  // Detail: Queue of available Drivers, not sorted
  private Deque<Driver> availableDrivers;

  private List<CompletedRide> allCompletedRides;

  // Detail: List of observers in this simulation is only the User Interface
  private Observer observer;

  /**
   * Private method to validate number of drivers and riders
   * @param numDrivers Integer representing the number of drivers
   * @param numRides Integer representing the number of rides to generate
   * @return Boolean representing whether the inputs are valid
   */
  private Boolean validInput(Integer numDrivers, Integer numRides){
    return numDrivers > ZERO && numRides > ZERO;
  }

  /**
   * Constructor for RideshareDispatchSimulator
   * @param numDrivers    Integer representing the number of drivers
   * @param numRides      Integer representing the number of rides
   * @param startTime     String representing the start time of the simulator
   * @param endTime       String representing the end time of the simulation
   * @throws RDSException is thrown when the number of drivers or rides is invalid
   */
  public RideshareDispatchSimulator(Integer numDrivers, Integer numRides, String startTime, String endTime) throws RDSException {
    if (this.validInput(numDrivers, numRides)) {
      // Set private fields
      this.numDrivers = numDrivers;
      this.numRides = numRides;
      this.startTime = ConversionUtility.convertTimeToInteger(startTime);
      this.endTime = ConversionUtility.convertTimeToInteger(endTime);
    } else {
      throw new RDSException("Number of drivers and rides must be greater than 0.");
    }
  }

  /**
   * Getter for number of drivers
   * @return Integer representing the number of drivers
   */
  public Integer getNumDrivers() {
    return numDrivers;
  }

  /**
   * Getter for number of rides
   * @return Integer representing the number of rides for this simulation
   */
  public Integer getNumRides() {
    return numRides;
  }

  /**
   * Getter for start time
   * @return Integer representing the Integer value for the start time
   */
  public Integer getStartTime() {
    return startTime;
  }

  /**
   * Getter for end time
   * @return Integer representing the Integer value for the end time
   */
  public Integer getEndTime() {
    return endTime;
  }

  /**
   * Getter for all available drivers
   * @return Deque of Drivers representing the Deque of available drivers
   */
  public Deque<Driver> getAvailableDrivers() {
    return availableDrivers;
  }

  /**
   * Getter for all completed rides for the simulation
   * @return List of CompletedRides representing all the completed rides in the simulation
   */
  public List<CompletedRide> getAllCompletedRides() {
    return allCompletedRides;
  }

  /**
   * Getter for the dispatch observer
   * @return Observer representing the observer
   */
  public Observer getObserver() {
    return observer;
  }

  /**
   * Private method to generate data based on the inputted arguments
   */
  private void generateData(){
    // Detail: All requested rides will be sorted via their calculated priority time
    allRequestedRides = new PriorityQueue<>(new RequestRideComparator());
    // Detail: All active rides will be sorted via their calculated end time
    allActiveRides = new PriorityQueue<>(new ActiveRideComparator());
    // Detail: All pending rides will be sorted via their priority status
    allPendingRides = new PriorityQueue<>(new PendingRideComparator());
    // Detail: List of all completed rides for analysis
    allCompletedRides = new ArrayList<>();
    SecureRandom random = Random.getInstance();
    for (int i = 0; i < numRides; ++i) {
      // Codewalk: Generate fake data
      Integer customerId = i + 1;
      String location = RANDOM_LOCATIONS[random.nextInt(RANDOM_LOCATIONS.length)];
      String desiredLocation = RANDOM_LOCATIONS[random.nextInt(RANDOM_LOCATIONS.length)];
      Double distance = random.nextDouble(DISTANCE_LOWER_BOUND, DISTANCE_UPPER_BOUND);
      Integer time = random.nextInt(this.startTime, this.endTime);
      Integer priority = random.nextInt(PRIORITY_BOUND) + 1;
      // DEBUG PRINT STATEMENT
      //System.out.println(customerId + " " + location + " " + desiredLocation + " " + distance + " " + time + " " + priority);

      // Codewalk: Create a new requested ride with the information
      RideInfo ride = new RideInfo(customerId, location, desiredLocation, distance, time, priority);
      RequestedRide newRide = new RequestedRide(ride);
      allRequestedRides.add(newRide);
    }
  }

  /**
   * Private method to generate the appropriate amount of drivers
   */
  private void generateDrivers(){
    this.availableDrivers = new ArrayDeque<>();
    for (int i = 0; i < this.numDrivers; ++i){
      Driver newDriver = new Driver(i + 1);
      this.availableDrivers.addLast(newDriver);
    }
  }

  /**
   * Private method to process the end of an active ride
   * @param finishedRide ActiveRide representing the finished ride
   */
  private void processRideFinish(ActiveRide finishedRide){
    // Codewalk: Dispatch below will poll the active ride that is now done and pass it as an argument
    Driver freeDriver = finishedRide.getDriver();
    freeDriver.addRide();
    Integer actualStartTime = finishedRide.getActualStartTime();
    Integer timeWaited = finishedRide.calculateTimeWaited();
    CompletedRide ride = new CompletedRide(finishedRide.getRide(), actualStartTime, finishedRide.getEndTime(),
        freeDriver.getDriverId(), timeWaited);
    // Codewalk: Dispatch will notify the user of the completed ride
    this.notifyUserEndRide(finishedRide);
    // Codewalk: The driver will be added back to the available drivers queue
    availableDrivers.addLast(freeDriver);
    allCompletedRides.add(ride);
  }

  /**
   * Private method to process a ride request
   * @param ride RequestedRide representing the requested ride from a user
   * @param startTime Integer representing the time that it was requested
   */
  private void processRideRequest(RequestedRide ride, Integer startTime){
    // Codewalk: Try to process this ride
    // If there's a driver available, start it
    // If not, add it to pending
    if (!this.availableDrivers.isEmpty()){
      this.startRide(ride, startTime);
    } else {
      this.allPendingRides.add(ride);
    }
  }

  /**
   * Private method to start a ride
   * @param ride RequestedRide representing the requested ride to be converted into an active ride
   * @param startTime Integer representing the time that the ride actually started
   */
  private void startRide(RequestedRide ride, Integer startTime){
    // Codewalk: If we get to this point, we know there is a driver available
    // Turn the RequestedRide into an ActiveRide with a Driver attached
    Driver driver = availableDrivers.pollFirst();
    RideInfo rideInfo = ride.getRide();
    ActiveRide newActiveRide = new ActiveRide(rideInfo, startTime, driver);
    this.allActiveRides.add(newActiveRide);
    this.notifyUserStartRide(newActiveRide);
  }

  /**
   * Method to add an observer - in this case, we will only have one which is the User Interface
   * @param o Observer representing the user interface
   */
  @Override
  public void addObserver(Observer o) {
    this.observer = o;
  }

  /**
   * Method to remove an observer
   * @param o Observer representing the user interface to remove
   */
  @Override
  public void removeObserver(Observer o) {
    this.observer = null;
  }

  /**
   * Method to notify a user that a ride has been started
   * @param ride ActiveRide representing the requested ride that has been converted into an active ride
   */
  @Override
  public void notifyUserStartRide(ActiveRide ride) {
    this.observer.updateUserStartRide(ride);
  }

  /**
   * Method to notify a user that a ride has been completed
   * @param ride ActiveRide representing the ride that has been completed
   */
  @Override
  public void notifyUserEndRide(ActiveRide ride) {
    this.observer.updateUserEndRide(ride);
  }

  /**
   * Private method to write all the results into a CSV file
   */
  private void writeResultsToCSV(){
    // Codewalk: Print average wait time
    Integer totalWaitTime = this.allCompletedRides.stream().mapToInt(completedRide -> completedRide.getTimeWaited()).sum();
    Double avgWaitTime = totalWaitTime.doubleValue() / this.numRides;
    System.out.println("The average wait time for a customer was: " + String.format("%02f", avgWaitTime));

    // Codewalk: Print average number of drives per driver
    Integer totalDrives = this.availableDrivers.stream().mapToInt(driver -> driver.getNumDrives()).sum();
    Double avgDrives = totalDrives.doubleValue() / this.numDrivers;
    System.out.println("The average number of drives per driver was: " + String.format("%02f", avgDrives));

    try (FileWriter writer = new FileWriter(OUTPUT_FILE)){
      // Write the header of the CSV
      writer.write("Ride Number, Customer ID, Driver ID, Starting Location, Ending Location, "
          + "Anticipated Distance, Ride Requested, Actual Time, End Time, Time Waited, Type of Ride\n");

      // For each separate ride, record the details of it
      for (int i = 0; i < this.allCompletedRides.size(); ++i){
        CompletedRide ride = this.allCompletedRides.get(i);
        writer.write(Integer.toString(i + 1));
        writer.write(", " + ride.getRide().getCustomerID());
        writer.write(", " + ride.getDriverId());
        writer.write(", " + ride.getRide().getStartingLocation());
        writer.write(", " + ride.getRide().getDesiredLocation());
        writer.write(", " + ride.getRide().getRideDistance());
        writer.write(", " + ConversionUtility.convertTimeToString(ride.getRide().getTimeRequested()));
        writer.write(", " + ConversionUtility.convertTimeToString(ride.getActualStartTime()));
        writer.write(", " + ConversionUtility.convertTimeToString(ride.getEndTime()));
        writer.write(", " + ride.getTimeWaited());
        writer.write(", " + ConversionUtility.convertPriortyFromInteger(ride.getRide().getPriority()));
        writer.write("\n");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  /**
   * Method to run the simulation
   */
  public void runSimulation(){
    // Codewalk: Generate fake data
    this.generateData();

    // Codewalk: Generate drivers
    this.generateDrivers();

    // Codewalk: To mimic the passage of time, we will increment through the day in minutes
    for (int currentTime = 0; currentTime < MINUTES_IN_DAY; ++currentTime){

      // Codewalk: Process all possible end of rides so that drivers can be freed
      while (!this.allActiveRides.isEmpty() && this.allActiveRides.peek().getEndTime() <= currentTime){
        this.processRideFinish(this.allActiveRides.poll());
      }

      // Codewalk: Process all pending rides - we check if there is a driver available to take this
      // So we can start the ride if this is true
      while (!this.allPendingRides.isEmpty() && !this.availableDrivers.isEmpty()){
        this.startRide(this.allPendingRides.poll(), currentTime);
      }

      // Codewalk: Process all possible rides at this exact time
      while (!this.allRequestedRides.isEmpty() && this.allRequestedRides.peek().getPriorityTime() <= currentTime){
        this.processRideRequest(this.allRequestedRides.poll(), currentTime);
      }
    }
    this.writeResultsToCSV();
  }
}

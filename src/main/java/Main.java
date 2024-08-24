import RideshareSimulator.RDSException;
import RideshareSimulator.RideshareDispatchSimulator;
import UIPackage.UserInterface;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of riders: ");
    int n = scanner.nextInt();
    System.out.print("Enter number of drivers: ");
    int d = scanner.nextInt();
    System.out.print("Enter start time (HH:MM): ");
    String startTime = scanner.next();
    System.out.print("Enter end time (HH:MM): ");
    String endTime = scanner.next();
    try {
      UserInterface ui = new UserInterface();
      RideshareDispatchSimulator simulator = new RideshareDispatchSimulator(d, n, startTime, endTime);
      simulator.addObserver(ui);
      simulator.runSimulation();
    } catch (RDSException | Exception e){
      e.printStackTrace();
    }
  }
}

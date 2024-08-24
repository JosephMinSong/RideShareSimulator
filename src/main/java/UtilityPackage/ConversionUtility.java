package UtilityPackage;

import RidePackage.RideType;

/**
 * ConversionUtility is a utility class meant to convert variables into an appropriate equivalent variable
 */
public class ConversionUtility {
  private final static Integer SIXTY = 60;

  /**
   * Constructor for ConversionUtility
   */
  public ConversionUtility() {
  }

  /**
   * Method to convert a String time into an Integer time
   * @param time String representing the String time (HH:MM) format
   * @return Integer representing the equivalent Integer time
   */
  public static Integer convertTimeToInteger(String time) {
    String[] t = time.split(":");
    return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
  }

  /**
   * Method to convert an Integer time into a String time
   * @param time Integer representing the Integer time (in minutes) format
   * @return String representing the equivalent String time
   */
  public static String convertTimeToString(Integer time) {
    Integer totalHours = time / SIXTY;
    Integer totalMinutes = time % SIXTY;
    return String.format("%02d:%02d", totalHours, totalMinutes);
  }


  /**
   * Method to convert an Integer priority into an Enum priority
   * @param priority Integer representing the Integer priority equivalence
   * @return RideType Enum representing the Enum priority equivalence
   */
  public static RideType convertPriortyFromInteger(Integer priority){
    RideType ans = switch (priority) {
      case 1 -> RideType.EXPRESS;
      case 2 -> RideType.STANDARD;
      case 3 -> RideType.WAIT_AND_SAVE;
      case 4 -> RideType.ENVIRONMENTALLY_CONSCIOUS;
      default -> RideType.STANDARD;
    };
    return ans;
  }
}

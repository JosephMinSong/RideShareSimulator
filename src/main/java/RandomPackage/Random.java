package RandomPackage;

import java.security.SecureRandom;

/**
 * Random is a concrete class that uses the singleton design pattern to only generate one instance of Random
 */
public class Random {
  private static SecureRandom random_instance = null;

  private Random() {}

  /**
   * Method to get the single instance of random to be used throughout the simulation
   * @return SecureRandom representing the seeded Random instance
   */
  public static synchronized SecureRandom getInstance() {
    if (random_instance == null) {
      random_instance = new SecureRandom();
    }
    return random_instance;
  }
}

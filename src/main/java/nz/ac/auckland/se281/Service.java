package nz.ac.auckland.se281;

public abstract class Service {
  private int cost;
  private int bookingReference;
  private int totalCost;
  
  public Service() {

  }

  abstract int getTotalCost();
}

package nz.ac.auckland.se281;

public abstract class Service {
  protected int cost;
  protected Booking booking;
  protected int totalCost;
  
  public Service(int cost, Booking booking) {
    this.cost = cost;
    this.booking = booking;
  }

  abstract int getTotalCost();
}

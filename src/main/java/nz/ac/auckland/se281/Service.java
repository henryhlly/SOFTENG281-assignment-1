package nz.ac.auckland.se281;

public abstract class Service {
  protected int costPerPerson;
  protected Booking booking;
  protected int totalCost;
  
  public Service(int costPerPerson, Booking booking) {
    this.costPerPerson = costPerPerson;
    this.booking = booking;
  }

  public int getCostPerPerson() {
    return costPerPerson;
  }

  abstract int getTotalCost();
}

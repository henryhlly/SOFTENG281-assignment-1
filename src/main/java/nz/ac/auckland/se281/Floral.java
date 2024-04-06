package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service{

  FloralType floralType;

  public Floral(FloralType floralType, Booking booking) {
    super(floralType.getCost(), booking);
    this.floralType = floralType;
  }

  public String getFloralType() {
    return floralType.getName();
  }

  public int getTotalCost() {
    totalCost = (floralType.getCost() * booking.getNumberOfAttendees());
    return totalCost;
  }
}

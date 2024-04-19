package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private CateringType cateringType;

  public Catering(CateringType cateringType, Booking booking) {
    super(cateringType.getCostPerPerson(), booking);
    this.cateringType = cateringType;
  }

  // Getter method for cateringType
  public String getCateringType() {
    return cateringType.getName();
  }

  public int getTotalCost() {
    totalCost = (cateringType.getCostPerPerson() * booking.getNumberOfAttendees());
    return totalCost;
  }
}

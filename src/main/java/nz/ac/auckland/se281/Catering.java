package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  CateringType cateringType;
  
  public Catering(CateringType cateringType, Booking booking) {
    super(cateringType.getCostPerPerson(), booking);
  }

  public int getTotalCost() {
    totalCost = (cateringType.getCostPerPerson() * booking.getNumberOfAttendees());
    return totalCost;
  }
}

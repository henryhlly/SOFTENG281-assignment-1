package nz.ac.auckland.se281;

public class Venue {
  private String venueName;
  private String venueCode;
  private int venueCapacity;
  private int hireFee;

  
  public Venue(String venueName, String venueCode, int venueCapacity, int hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.venueCapacity = venueCapacity;
    this.hireFee = hireFee;
  }

  // Getter method for venueName
  public String getVenueName() {
    return venueName;
  }

  // Getter method for venueCode
  public String getVenueCode() {
    return venueCode;
  }

  // Getter method for venueCapacity
  public int getVenueCapacity() {
    return venueCapacity;
  }
 
  // Getter method for hireFee
  public int getHireFee() {
    return hireFee;
  }
}

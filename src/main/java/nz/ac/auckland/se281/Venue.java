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
 
}

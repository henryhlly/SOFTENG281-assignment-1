package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private Venue venue;
  private String bookingDate;
  private String emailAddress;
  private int numberOfAttendees;

  public Catering catering;
  public Music music;
  public Floral floral;

  public Booking(Venue venue, String bookingDate, String emailAddress, int numberOfAttendees) {
    this.venue = venue;
    this.bookingDate = bookingDate;
    this.emailAddress = emailAddress;
    this.numberOfAttendees = numberOfAttendees;
    this.bookingReference = BookingReferenceGenerator.generateBookingReference();
  }

  // Getter method for bookingReference
  public String getBookingReference() {
    return bookingReference;
  }

  // Getter method for venue
  public Venue getVenue() {
    return venue;
  }

  // Getter method for bookingDate
  public String getBookingDate() {
    return bookingDate;
  }

  // Getter method for emailAddress
  public String getEmailAddress() {
    return emailAddress;
  }

  // Getter method for numberOfAttendees
  public int getNumberOfAttendees() {
    return numberOfAttendees;
  }

  // Method to add services, if service already exists replace it with the new one.
  public void addCatering(Catering catering) {
    if (this.catering != null) {
      System.out.println("The old catering service has been replaced with the new one.");
    }
    this.catering = catering;
  }

  public void addMusic(Music music) {
    if (this.catering != null) {
      System.out.println("The old music service has been replaced with the new one.");
    }
    this.music = music;
  }

  public void addFloral(Floral floral) {
    this.floral = floral;
  }

  // Getter methods for the services respectively
  public Catering getCatering() {
    return catering;
  }

  public Music getMusic() {
    return music;
  }

  public Floral getFloral() {
    return floral;
  }
}

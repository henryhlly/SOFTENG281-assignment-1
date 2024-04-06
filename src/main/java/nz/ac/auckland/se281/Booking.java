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

  public String getBookingReference() {
    return bookingReference;
  }

  public Venue getVenue() {
    return venue;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public int getNumberOfAttendees() {
    return numberOfAttendees;
  }


  public void addCatering(Catering catering) {
    this.catering = catering;
  }

  public void addMusic(Music music) {
    this.music = music;
  }

  public void addFloral(Floral floral) {
    this.floral = floral;
  }

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

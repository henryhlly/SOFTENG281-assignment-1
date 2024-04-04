package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String venueCode;
  private String bookingDate;
  private String emailAddress;
  private String numberOfAttendees;

  public Booking(
      String venueCode, String bookingDate, String emailAddress, String numberOfAttendees) {
    this.venueCode = venueCode;
    this.bookingDate = bookingDate;
    this.emailAddress = emailAddress;
    this.numberOfAttendees = numberOfAttendees;
    this.bookingReference = BookingReferenceGenerator.generateBookingReference();
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getNumberOfAttendees() {
    return numberOfAttendees;
  }
}

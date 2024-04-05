package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Booking {
  private String bookingReference;
  private String venueCode;
  private String bookingDate;
  private String emailAddress;
  private int numberOfAttendees;
  private ArrayList<Service> services = new ArrayList<Service>();

  public Booking(String venueCode, String bookingDate, String emailAddress, int numberOfAttendees) {
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

  public int getNumberOfAttendees() {
    return numberOfAttendees;
  }

  public void addService(Service serviceObject) {
    services.add(serviceObject);
  }
}

package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Booking {
  private String bookingReference;
  private Venue venue;
  private String bookingDate;
  private String emailAddress;
  private int numberOfAttendees;
  private ArrayList<Service> services = new ArrayList<Service>();

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

  public void addService(Service serviceObject) {
    services.add(serviceObject);
  }
}

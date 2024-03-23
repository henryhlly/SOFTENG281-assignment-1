package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

import java.util.ArrayList;

public class VenueHireSystem {
  ArrayList<String> venue_names = new ArrayList<String>();
  ArrayList<String> venue_codes = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    System.out.println("There are no venues in the system. Please create a venue first.");
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // Testing venueName validity
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    // Testing venueCode validity
    else if (venue_codes.contains(venueCode)) {
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue_names.get(venue_codes.indexOf(venueCode)));
    }
    else { 
      // Testing venueCapacity validity
      try {
        Integer.parseInt(capacityInput);
      } catch(Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " ");
      }
      int venueCapacity = Integer.parseInt(capacityInput);
      if (venueCapacity <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      }

      // Testing hireFee validity
      try {
        Integer.parseInt(hireFeeInput);
      } catch(Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " ");
      }
      int hireFee = Integer.parseInt(capacityInput);
      if (hireFee <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      }
    }
    
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}

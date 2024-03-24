package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

import java.util.ArrayList;

public class VenueHireSystem {
  ArrayList<Venue> venues = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    int quantity = venues.size();
    String[] numStrings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    // Print intital statement for all cases
    if (quantity==0) {
      MessageCli.NO_VENUES.printMessage();
    }
    if (quantity==1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    }
    else if (quantity < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", numStrings[quantity], "s");
    }
    else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(quantity), "s");
    }
  
    for (Venue v:venues) {
      MessageCli.VENUE_ENTRY.printMessage(v.getVenueName(), v.getVenueCode(), String.valueOf(v.getVenueCapacity()), String.valueOf(v.getHireFee()), "");
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    boolean valid = true;

    // Testing venueName validity
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      valid = false;
    }
    
    else {
      // Testing venueCode validity
      for (Venue v: venues) {
        if (venueCode==v.getVenueCode()) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, v.getVenueName());
          valid = false;
        }
      }

      // Testing venueCapacity validity
      try {
        Integer.parseInt(capacityInput);
      } catch(Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " ");
        valid = false;
      }
      int venueCapacity = Integer.parseInt(capacityInput);
      if (venueCapacity <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        valid = false;
      }

      // Testing hireFee validity
      try {
        Integer.parseInt(hireFeeInput);
      } catch(Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " ");
        valid = false;
      }
      int hireFee = Integer.parseInt(capacityInput);
      if (hireFee <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        valid = false;
      }

      // Create the new Venue
      if (valid == true) {
        Venue venue = new Venue(venueName, venueCode, venueCapacity, hireFee);
        venues.add(venue);
        MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
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

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
    else if (quantity==1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    }
    else if (quantity < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", numStrings[quantity], "s");
    }
    else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(quantity), "s");
    }
    
    // Print itemised list of all existing venues
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
    
    //Testing venueCode validity
    else {
      for (Venue v: venues) {
        if (venueCode.equals(v.getVenueCode())) {
          
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, v.getVenueName());
          valid = false;
        }
      }
    }
      
    // Testing venueCapacity validity
    if (valid) {valid = (checkPositiveInteger(capacityInput, "capacity"));}

    //Testing hireFee validity
    if (valid) {valid = (checkPositiveInteger(hireFeeInput, "hire fee"));}
        
    // Create the new Venue
    if (valid == true) {
      int venueCapacity = Integer.parseInt(capacityInput);
      int hireFee = Integer.parseInt(hireFeeInput);
      Venue venue = new Venue(venueName, venueCode, venueCapacity, hireFee);
      venues.add(venue);
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  // New method for checking whether an input is a positive integer and returns boolean/displays appropriate error message if it is not
  public boolean checkPositiveInteger(String input, String var_name) {
    try {
      if (Integer.parseInt(input) <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(var_name, " positive");
        return (false);
      }
      else {
        return (true);
      }

    } catch(Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(var_name, "");
      return (false);
    }
  }

  
  //// Checkpoint 2 ////

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

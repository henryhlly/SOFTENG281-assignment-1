package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  ArrayList<Venue> venues = new ArrayList<Venue>();
  String systemDate = "";

  public VenueHireSystem() {}

  public void printVenues() {
    int quantity = venues.size();
    String[] numStrings = {
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
    };

    // Print intital statement for all cases
    if (quantity == 0) {
      MessageCli.NO_VENUES.printMessage();
    } else if (quantity == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    } else if (quantity < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", numStrings[quantity], "s");
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(quantity), "s");
    }

    // Print itemised list of all existing venues
    for (Venue v : venues) {
      MessageCli.VENUE_ENTRY.printMessage(
          v.getVenueName(),
          v.getVenueCode(),
          String.valueOf(v.getVenueCapacity()),
          String.valueOf(v.getHireFee()),
          "");
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    boolean valid = true;

    // Testing venueName validity
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      valid = false;
    }

    // Testing venueCode validity
    else {
      for (Venue v : venues) {
        if (venueCode.equals(v.getVenueCode())) {

          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, v.getVenueName());
          valid = false;
        }
      }
    }

    // Testing venueCapacity validity
    if (valid) {
      valid = (checkPositiveInteger(capacityInput, "capacity"));
    }

    // Testing hireFee validity
    if (valid) {
      valid = (checkPositiveInteger(hireFeeInput, "hire fee"));
    }

    // Create the new Venue
    if (valid == true) {
      int venueCapacity = Integer.parseInt(capacityInput);
      int hireFee = Integer.parseInt(hireFeeInput);
      Venue venue = new Venue(venueName, venueCode, venueCapacity, hireFee);
      venues.add(venue);
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  // New method for checking whether an input is a positive integer and returns boolean/displays
  // appropriate error message if it is not
  public boolean checkPositiveInteger(String input, String var_name) {
    try {
      if (Integer.parseInt(input) <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(var_name, " positive");
        return (false);
      } else {
        return (true);
      }

    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(var_name, "");
      return (false);
    }
  }

  //// Checkpoint 2 ////

  public void setSystemDate(String dateInput) {
    systemDate = dateInput;
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {
    if (systemDate.isEmpty()) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(systemDate);
    }
  }

  public void makeBooking(String[] options) {
    // 0 - venueCode, 1 - bookingDate, 2 - email address, 3 - number of attendees
    boolean valid = true;
    String venueName = "";

    // Test for unset system date
    if (systemDate.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      valid = false;
    }
    // Test for empty venues list
    else if (venues.size() == 0) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      valid = false;
    } else {
      // Test for invalid venue code
      for (Venue v : venues) {
        if (v.getVenueCode().equals(options[0])) {
          valid = true;
          venueName = v.getVenueName();
          break;
        } else {
          valid = false;
        }
      }
      if (!valid) {
        MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      }

      // Test for past booking date
      if (systemDate.compareTo(options[1]) > 0) {
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
        valid = false;
      }
    }

    if (valid) {
      Booking booking = new Booking(options[0], options[1], options[2], options[3]);
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
          booking.getBookingReference(),
          venueName,
          booking.getBookingDate(),
          booking.getNumberOfAttendees());
    }
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

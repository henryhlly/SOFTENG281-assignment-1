package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VenueHireSystem {
  ArrayList<Venue> venues = new ArrayList<Venue>();
  ArrayList<Booking> bookings = new ArrayList<Booking>();
  LocalDate systemDate = null;
  DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  int numberOfAttendees;

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
      MessageCli.VENUE_ENTRY.printMessage(v.getVenueName(), v.getVenueCode(), String.valueOf(v.getVenueCapacity()), String.valueOf(v.getHireFee()),v.getNextAvailableTime(systemDate));
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {

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
    // Get the date out string using specified format
    systemDate = LocalDate.parse(dateInput, dateformatter);
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {
    if (systemDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(dateformatter.format(systemDate));
    }
  }

  public void makeBooking(String[] options) {
    // options[0] - venueCode, options[1] - bookingDate, options[2] - email address, options[3] - number of attendees
    boolean valid = true;
    int venueIndex = -1;

    // Test for unset system date
    if (systemDate == null) {
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
          venueIndex = venues.indexOf(v);
          break;
        } else {
          valid = false;
        }
      }
      if (!valid) {
        MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      }

      // Test for past booking date
      else if (systemDate.isAfter(LocalDate.parse(options[1], dateformatter))) {
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], dateformatter.format(systemDate));
        valid = false;
      } else {
        // Test for existing bookings on the same date and same venue
        for (Booking b : bookings) {
          if (b.getVenueCode().equals(options[0]) && b.getBookingDate().equals(options[1])) {
            MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venues.get(venueIndex).getVenueName(), options[1]);
            valid = false;
            break;
          }
        }
      }
    }

    // Test for unideal number of attendees
    if (valid) {
      int venueCapacity = venues.get(venueIndex).getVenueCapacity();
      numberOfAttendees = Integer.parseInt(options[3]);
      if (numberOfAttendees < (0.25 * venueCapacity)) {
        System.out.println((int) (0.25*venueCapacity));
        numberOfAttendees = (int) (0.25 * venueCapacity);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], String.valueOf(numberOfAttendees), String.valueOf(venueCapacity));
      }
      else if (numberOfAttendees > venueCapacity) {
        numberOfAttendees = venueCapacity;
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], String.valueOf(numberOfAttendees), String.valueOf(venueCapacity));
      }
    }

    // Create Booking
    if (valid) {
      Booking booking = new Booking(options[0], options[1], options[2], numberOfAttendees);
      bookings.add(booking);
      venues.get(venueIndex).addBookedDate(options[1]);
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(booking.getBookingReference(), venues.get(venueIndex).getVenueName(), booking.getBookingDate(), String.valueOf(booking.getNumberOfAttendees()));
    }
  }

  public void printBookings(String venueCode) {
    boolean valid = false;
    boolean no_bookings = true;
    int venueIndex = -1;

    // Test for existing index
    for (Venue v : venues) {
      if (v.getVenueCode().equals(venueCode)) {
        valid = true;
        venueIndex = venues.indexOf(v);
        break;
      }
    }
    if (!valid) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    } 
    else {
      // Print bookings accordingly
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venues.get(venueIndex).getVenueName());
      for (Booking b : bookings) {
        if (b.getVenueCode().equals(venueCode)) {
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(b.getBookingReference(), b.getBookingDate(), b.getEmailAddress(), String.valueOf(b.getNumberOfAttendees()));
          no_bookings = false;
        }
      }
      if (no_bookings) {
        MessageCli.PRINT_BOOKINGS_NONE.printMessage(venues.get(venueIndex).getVenueName());
      }
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    boolean valid = false;
    // Test for existing booking reference
    for (Booking b : bookings) {
      if (b.getBookingReference().equals(bookingReference)) {
        valid = true;
        // Create catering service
        Service catering = new Catering(cateringType, b);
        b.addService(catering);
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Catering (" + cateringType.getName() + ")", bookingReference);
        break;
      }
    }
    if (!valid) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
    }
  }

  public void addServiceMusic(String bookingReference) {
    boolean valid = false;
    // Test for existing booking reference
    for (Booking b : bookings) {
      if (b.getBookingReference().equals(bookingReference)) {
        valid = true;
        // Create music service
        Service music = new Music(b);
        b.addService(music);
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
        break;
      }
    }
    if (!valid) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
    }
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    boolean valid = false;
    // Test for existing booking reference
    for (Booking b : bookings) {
      if (b.getBookingReference().equals(bookingReference)) {
        valid = true;
        // Create floral service
        Service floral = new Floral(floralType, b);
        b.addService(floral);
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Floral (" + floralType.getName() + ")", bookingReference);
        break;
      }
    }
    if (!valid) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
    }
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}

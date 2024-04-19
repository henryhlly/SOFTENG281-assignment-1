package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Venue {
  private String venueName;
  private String venueCode;
  private int venueCapacity;
  private int hireFee;
  private ArrayList<String> bookedDates = new ArrayList<String>();
  DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Venue(String venueName, String venueCode, int venueCapacity, int hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.venueCapacity = venueCapacity;
    this.hireFee = hireFee;
  }

  // Getter method for venueName
  public String getVenueName() {
    return venueName;
  }

  // Getter method for venueCode
  public String getVenueCode() {
    return venueCode;
  }

  // Getter method for venueCapacity
  public int getVenueCapacity() {
    return venueCapacity;
  }

  // Getter method for hireFee
  public int getHireFee() {
    return hireFee;
  }

  // Setter method for bookedDates
  public void addBookedDate(String date) {
    bookedDates.add(date);
  }

  // Getter method for bookedDates
  public String getNextAvailableTime(LocalDate systemDate) {
    if (systemDate == null) {
      return "N/A";
    } else {
      LocalDate availableDate = systemDate;

      Collections.sort(bookedDates);

      for (String date : bookedDates) {
        LocalDate bookedDate = LocalDate.parse(date, dateformatter);
        if (bookedDate.isEqual(availableDate)) {
          availableDate = availableDate.plusDays(1);
        }
      }
      return dateformatter.format(availableDate);
    }
  }
}

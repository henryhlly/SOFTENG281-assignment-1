package nz.ac.auckland.se281;

public class Music extends Service {

  public Music(Booking booking) {
    super(500, booking);
  }

  public int getTotalCost() {
    return 500;
  }
}

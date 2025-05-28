
public class Main {
  public static void main(String[] args) {
    SpeedInKMH speedInKMH = new SpeedInKMH(100);
    SpeedometerMPH speedAdapter = new SpeedAdapter(speedInKMH);

    System.out.println("Speed in MPH: " + speedAdapter.getSpeed());
  }
}
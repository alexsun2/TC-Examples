//adapter class: adapts SpeedInKMH to target interface, SpeedometerMPH

public class SpeedAdapter implements SpeedometerMPH {

  private SpeedInKMH speedInKMH;

  public SpeedAdapter(SpeedInKMH speed) {
    this.speedInKMH = speed;
  }

  @Override
  public double getSpeed() {
    return this.speedInKMH.getSpeedInKMH() * 0.621371;
  }
}

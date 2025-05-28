//Strategy that chooses an aggressive/offensive move.

public class OffensiveStrategy implements Strategy {

  //in an application of a game, chooseMove() will pass through the game model and will return the suggested move.
  @Override
  public void chooseMove() {
    System.out.println("Enemy Chooses to Attack.");
  }
}

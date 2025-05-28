//Strategy that chooses a defensive move.


public class DefensiveStrategy implements Strategy {

  //in an application of a game, chooseMove() will pass through the game model and will return the suggested move.
  @Override
  public void chooseMove() {
    System.out.println("Enemy Chooses to Defend");
  }
}

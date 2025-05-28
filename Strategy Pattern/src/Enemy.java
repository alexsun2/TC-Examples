//Represents AI player that uses Strategy to chose their move on their turn.

public class Enemy {

  private Strategy strategy;

  public Enemy(Strategy strat) {
    this.strategy = strat;
  }

  public void setStrategy(Strategy strat) {
    this.strategy = strat;
  }

  public void takeTurn() {
    this.strategy.chooseMove();
  }

}

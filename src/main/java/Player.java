/**
 * The `Player` class represents a player in a tennis game. It keeps track of the player's name and
 * score.
 */
public class Player {

  /** The name of the player. */
  private final char name;

  /** The score of the player. */
  private int score;

  /**
   * Creates a new `Player` instance with the specified name.
   *
   * @param name the name of the player
   */
  public Player(char name) {
    this.name = name;
  }

  /**
   * Retrieves the name of the player.
   *
   * @return the name of the player
   */
  public char getName() {
    return name;
  }

  /**
   * Retrieves the score of the player.
   *
   * @return the score of the player
   */
  public int getScore() {
    return score;
  }

  /** Increments the score of the player by one. */
  public void incrementScore() {
    score++;
  }

  /**
   * Retrieves the score description of the player.
   *
   * @return the score description of the player
   */
  public ScoreDescription getScoreDescription() {
    for (ScoreDescription scoreDescription : ScoreDescription.values()) {
      if (scoreDescription.getScore() == score) {
        return scoreDescription;
      }
    }
    return ScoreDescription.UNKNOWN;
  }
}

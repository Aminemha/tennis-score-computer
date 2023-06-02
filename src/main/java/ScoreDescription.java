/**
 * The `ScoreDescription` enum represents the description and score value of a tennis score.
 */
public enum ScoreDescription {

  /**
   * Represents a score of "0".
   */
  LOVE("0", 0),

  /**
   * Represents a score of "15".
   */
  FIFTEEN("15", 1),

  /**
   * Represents a score of "30".
   */
  THIRTY("30", 2),

  /**
   * Represents a score of "40".
   */
  FORTY("40", 3),

  /**
   * Represents the advantage score.
   */
  ADVANTAGE("A", 4),

  /**
   * Represents an unknown score.
   */
  UNKNOWN("Unknown", 0);

  /**
   * The description of the score.
   */
  private final String description;

  /**
   * The score value.
   */
  private final int score;

  /**
   * Creates a new `ScoreDescription` enum with the specified description and score.
   *
   * @param description the description of the score
   * @param score       the score value
   */
  ScoreDescription(String description, int score) {
    this.description = description;
    this.score = score;
  }

  /**
   * Retrieves the description of the score.
   *
   * @return the description of the score
   */
  public String getDescription() {
    return description;
  }

  /**
   * Retrieves the score value.
   *
   * @return the score value
   */
  public int getScore() {
    return score;
  }
}
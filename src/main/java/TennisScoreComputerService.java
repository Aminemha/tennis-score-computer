/**
 * The `TennisScoreComputerService` class represents a computer that computes the score of a tennis game
 * between two players. It keeps track of the players' scores and determines the winner of the game.
 */
public class TennisScoreComputerService {

  /** The name of Player A in the game steps input string. */
  public static final char PLAYER_A_NAME = 'A';

  /** The name of Player B in the game steps input string. */
  public static final char PLAYER_B_NAME = 'B';

  /** The string representation of the game steps. */
  private final String game;

  /** The player object representing Player A. */
  private final Player playerA;

  /** The player object representing Player B. */
  private final Player playerB;

  /**
   * Creates a new `TennisScoreComputerService` instance with the specified game steps.
   *
   * @param game the string representation of the game steps
   */
  public TennisScoreComputerService(String game) {
    validateGame(game);
    this.game = game;
    playerA = new Player(PLAYER_A_NAME);
    playerB = new Player(PLAYER_B_NAME);
  }

  /**
   * Validates the game steps to ensure they only contain valid player names.
   *
   * @param game the string representation of the game steps
   * @throws IllegalArgumentException if the game steps contain invalid characters
   */
  private void validateGame(String game) {
    for (char player : game.toCharArray()) {
      if (player != PLAYER_A_NAME && player != PLAYER_B_NAME) {
        throw new IllegalArgumentException("Invalid game steps: " + game);
      }
    }
  }

  /**
   * Computes the score of the tennis game.
   *
   * @return the player object representing the winner of the game
   * @throws IllegalArgumentException if the game is not over yet
   */
  public Player computeScore() {
    int serveNumber = 0;
    for (char player : game.toCharArray()) {
      System.out.print(++serveNumber + "/" + game.length() + "(" + player + ")" + " => ");

      if (player == PLAYER_A_NAME) {
        playerA.incrementScore();
      } else if (player == PLAYER_B_NAME) {
        playerB.incrementScore();
      }

      if (isDeuce()) {
        printScore(ScoreDescription.FORTY, ScoreDescription.FORTY);
        System.out.println("Deuce");
      } else if (isAdvantage()) {
        Player playerWithAdvantage = getPlayerWithAdvantage();
        if (playerWithAdvantage.equals(playerA)) {
          printScore(ScoreDescription.ADVANTAGE, ScoreDescription.FORTY);
        } else {
          printScore(ScoreDescription.FORTY, ScoreDescription.ADVANTAGE);
        }
      } else if (isGameOver()) {
        System.out.println(String.format("Player %s wins the game", getWinner().getName()));
        break;
      } else {
        printScore(playerA.getScoreDescription(), playerB.getScoreDescription());
      }
    }
    return getWinner();
  }

  /**
   * Checks if the game is in a deuce state.
   *
   * @return true if the game is in deuce, false otherwise
   */
  private boolean isDeuce() {
    return playerA.getScore() >= 3
        && playerB.getScore() >= 3
        && playerA.getScore() == playerB.getScore();
  }

  /**
   * Checks if there is an advantage in the game.
   *
   * @return true if there is an advantage, false otherwise
   */
  private boolean isAdvantage() {
    return (playerA.getScore() >= 3 && playerB.getScore() >= 3)
        && (Math.abs(playerA.getScore() - playerB.getScore()) == 1);
  }

  /**
   * Checks if the game is over.
   *
   * @return true if the game is over, false otherwise
   */
  private boolean isGameOver() {
    return (playerA.getScore() >= 4 || playerB.getScore() >= 4)
        && (Math.abs(playerA.getScore() - playerB.getScore()) >= 2);
  }

  /**
   * Retrieves the winner of the game.
   *
   * @return the player object representing the winner
   * @throws IllegalArgumentException if the game is not over yet
   */
  private Player getWinner() {
    if (isGameOver()) {
      return (playerA.getScore() > playerB.getScore()) ? playerA : playerB;
    } else {
      throw new IllegalArgumentException("The game is not over yet");
    }
  }

  /**
   * Retrieves the player with the advantage in the game.
   *
   * @return the player object with the advantage
   */
  private Player getPlayerWithAdvantage() {
    return (playerA.getScore() > playerB.getScore()) ? playerA : playerB;
  }

  /**
   * Prints the scores of the players.
   *
   * @param playerAScoreDescription the score description of Player A
   * @param playerBScoreDescription the score description of Player B
   */
  private void printScore(
      ScoreDescription playerAScoreDescription, ScoreDescription playerBScoreDescription) {
    System.out.println(
        String.format(
            "Player A: %s - Player B: %s",
            playerAScoreDescription.getDescription(), playerBScoreDescription.getDescription()));
  }
}

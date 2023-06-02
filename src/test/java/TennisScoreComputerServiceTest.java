import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TennisScoreComputerServiceTest {

  public static Stream<Arguments> gamesInput() {
    return Stream.of(
        arguments("ABABAA", 'A'),
        arguments("BAAAA", 'A'),
        arguments("AABBBABB", 'B'),
        arguments("AAAA", 'A'),
        arguments("BABAAA", 'A'),
        arguments("AABBABABBAAA", 'A'),
        arguments("AABBBAABAA", 'A'),
        arguments("BAAABBABBAAA", 'A'),
        arguments("BAAABBABBAAAAAAAAAAA", 'A'),
        arguments("AAABBBBABB", 'B'));
  }

  @ParameterizedTest()
  @DisplayName("Should run multiple games")
  @MethodSource("gamesInput")
  void computeScore(final String game, final char expectedWinner) {
    TennisScoreComputerService scoreComputer = new TennisScoreComputerService(game);
    Player player = scoreComputer.computeScore();
    assertEquals(expectedWinner, player.getName());
  }

  @Test
  @DisplayName("Should throw an IllegalArgumentException when the game is not finished")
  void computeScoreWithUnfinishedGame() {
    // GIVEN
    String game = "BAAABBABB";
    TennisScoreComputerService scoreComputer = new TennisScoreComputerService(game);

    // WHEN / THEN
    assertThrows(IllegalArgumentException.class, scoreComputer::computeScore);
  }

  @Test
  @DisplayName(
      "Should throw an IllegalArgumentException when the game steps contains invalid character")
  void computeScoreWithInvalidGameStep() {
    // GIVEN
    String game = "BAAABCBAB";

    // WHEN / THEN
    assertThrows(IllegalArgumentException.class, () -> new TennisScoreComputerService(game));
  }
}

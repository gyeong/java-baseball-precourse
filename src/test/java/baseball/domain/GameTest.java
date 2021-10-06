package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {
    
    @DisplayName("Game 생성자 Test")
    @Test
    public void initGameTest() {
        Game game = new Game();
        assertEquals(0, game.getBallCount());
        assertEquals(0, game.getStrikeCount());
        assertNotNull(game.getRandomNumber());
    }
    
    @DisplayName("Game StrikeCount Test")
    @Test
    public void strikeCountTest() {
        Game game = new Game();
        assertEquals(0, game.getStrikeCount());
        game.setStrikeCount(1);
        game.setStrikeCount(1);
        assertEquals(2, game.getStrikeCount());
        game.setStrikeCount(0);
        assertEquals(0, game.getStrikeCount());
    }
    
    @DisplayName("Game BallCount Test")
    @Test
    public void ballCountTest() {
        Game game = new Game();
        assertEquals(0, game.getBallCount());
        game.setBallCount(1);
        game.setBallCount(1);
        assertEquals(2, game.getBallCount());
        game.setBallCount(0);
        assertEquals(0, game.getBallCount());
    }
    
    @DisplayName("Game IsAllStrike Test")
    @Test
    public void isAllStrikeTest() {
        Game game = new Game();
        assertFalse(game.isAllStrike(), "false");
        game.setStrikeCount(1);
        game.setStrikeCount(1);
        game.setStrikeCount(1);
        assertTrue(game.isAllStrike(), "true");
        
    }
    
    @DisplayName("Game GetGameResult Test")
    @ParameterizedTest
    @ValueSource(strings = {"157", "132", "327", "245", "274", "237", "273"})
    public void getGameResultTest(String input) {
        Game game = new Game();
        
        game.setRandomNumber("273");
        game.getGameResult(input.split(""));
        assertTrue(game.getStrikeCount() > 0 || game.getBallCount() > 0, "true");
    }
}

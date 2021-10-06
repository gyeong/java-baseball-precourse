package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GamePlayerTest {

    @DisplayName("GamePlayer 생성자 Test")
    @Test
    public void initGamePlayerTest() {
        GamePlayer player = new GamePlayer();
        assertNotNull(player.getPlayerNumber());
    }

}

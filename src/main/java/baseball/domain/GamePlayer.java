package baseball.domain;

import nextstep.utils.Console;

public class GamePlayer {
    private String playerNumber;
    
    public GamePlayer() {
        this.playerNumber = "";
    }
    
    public String getPlayerNumber() {
        return playerNumber;
    }
    
    public void setPlayerNumber() {
        this.playerNumber = Console.readLine();
    }
}

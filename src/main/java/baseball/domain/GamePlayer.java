package baseball.domain;

import nextstep.utils.Console;

public class GamePlayer {
    private String playerNumber;
    private String termNumber;
    
    public GamePlayer() {
        this.playerNumber = "";
        this.termNumber = "";
    }
    
    public String getPlayerNumber() {
        return playerNumber;
    }
    
    public void setPlayerNumber() {
        this.playerNumber = Console.readLine();
    }

    public String getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(String termNumber) {
        this.termNumber = Console.readLine();
    }
    
    
}

package baseball.controller;

import baseball.service.GameService;

public class GameController {
    
    public void startGame() {
        boolean status = false;
        while (!status) {
            GameService gameService = new GameService();
            status = gameService.playGame();
        }
    }
    
}

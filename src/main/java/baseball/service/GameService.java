package baseball.service;

import baseball.domain.Game;
import baseball.domain.GamePlayer;
import baseball.domain.GamePresenter;
import baseball.utils.CommonUtil;

public class GameService {
    private Game game;
    private GamePlayer player;
    private GamePresenter presenter;
    
    public GameService() {
        game = new Game();
        player = new GamePlayer();
        presenter = new GamePresenter();
    }
    
    /**
     * 게임 프로세스
     */
    public boolean playGame() {
        while (!game.isAllStrike()) {
            pickNumbers();
            compareNumbers();
            printResult();
        }
        return askNewGame();
    }
    
    /**
     * 번호 선택
     */
    private void pickNumbers() {
        boolean valid = false;
        
        while (!valid) {
            presenter.printIntroMsg();
            player.setPlayerNumber();
            valid = presenter.checkValidation(player.getPlayerNumber());
        }
    }
    
    private void compareNumbers() {
        String[] inputArr = player.getPlayerNumber().split("");
        
        for (int i=0; i<CommonUtil.GAME_INPUT_LENGTH; i++) {
            game.compareNumber(inputArr[i], i);
        }
    }
    
    private void printResult() {
        presenter.printResultMsg(game.getStrikeCount(), game.getBallCount());
    }
    
    private boolean askNewGame() {
        boolean valid = false;
        
        presenter.printSuccessMsg();
        while (!valid) {
            presenter.printSelectionMsg();
            player.getTermNumber();
            valid = presenter.checkTermValidation(player.getTermNumber());
        }
        
        return presenter.isEnd(player.getTermNumber());
   }
}

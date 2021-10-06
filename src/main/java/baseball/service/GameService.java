package baseball.service;

import baseball.domain.Game;
import baseball.domain.GamePlayer;
import baseball.domain.GamePresenter;
import nextstep.utils.Console;

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
        while (!checkStatus()) {
            pickNumbers();
            getGameResult();
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
            player.setPlayerNumber(Console.readLine());
            valid = presenter.checkValidation(player.getPlayerNumber());
        }
    }
    
    /**
     * 사용자번호와 랜덤번호 비교
     */
    private void getGameResult() {
        String[] inputArr = player.getPlayerNumber().split("");
        
        game.getGameResult(inputArr);
    }
    
    /**
     * 게임 결과 출력
     */
    private void printResult() {
        presenter.printResultMsg(game.getStrikeCount(), game.getBallCount());
    }
    
    /**
     * 게임 상태 체크
     */
    private boolean checkStatus() {
        if (game.isAllStrike()) {
            presenter.printSuccessMsg();
            return true;
        }
        
        return false;
    }
    
    /**
     * 게임 지속 여부 확인
     */
    private boolean askNewGame() {
        boolean valid = false;
        String input = "";
        
        while (!valid) {
            presenter.printSelectionMsg();
            input = Console.readLine();
            valid = presenter.checkTermValidation(input);
        }
        
        return presenter.isEnd(input);
   }
}

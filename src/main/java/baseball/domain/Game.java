package baseball.domain;

import baseball.utils.CommonUtil;
import nextstep.utils.Randoms;

public class Game {
    private String randomNumber;
    private int strikeCount;
    private int ballCount;
    
    public Game() {
        this.randomNumber = "";
        
        for (int i=0; i<CommonUtil.GAME_INPUT_LENGTH; i++) {
            this.randomNumber += Integer.toString(Randoms.pickNumberInRange(CommonUtil.GAME_NUMBER_MIN, CommonUtil.GAME_NUMBER_MAX));
        }
    }
    
    public String getRandomNumber() {
        return randomNumber;
    }
    
    public int getStrikeCount() {
        return strikeCount;
    }
    
    public int getBallCount() {
        return ballCount;
    }
    
    /**
     * 스트라이크 카운트 값 세팅
     * @param strikeCount
     */
    public void setStrikeCount(int strikeCount) {
        if (strikeCount == 0) {
            this.strikeCount = 0;
            return;
        }
        this.strikeCount += strikeCount;
    }
    
    /**
     * 골 카운트 값 세팅
     * @param goalCount
     */
    public void setGoalCount(int ballCount) {
        if (ballCount == 0) {
            this.ballCount = 0;
            return;
        }
        this.ballCount += ballCount;
    }
    
    /**
     * 랜덤 숫자와 사용자 입력 숫자 비교
     * @param inputNum
     * @param inputNumIndex
     */
    public void compareNumber(String inputNum, int inputNumIndex) {
        int randomNumIndex = this.randomNumber.indexOf(inputNum);
        
        if (randomNumIndex == inputNumIndex) {
            setStrikeCount(1);
            return;
        }
        
        if (randomNumIndex >= 0 ) {
            setGoalCount(1);
        }
    }
    
    /**
     * 올 스트라이크 체크
     */
    public boolean isAllStrike() {
        if (this.strikeCount == CommonUtil.GAME_INPUT_LENGTH) {
            return true;
        }
        
        return false;
    }
}

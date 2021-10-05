package baseball.domain;

import nextstep.utils.Randoms;

public class Game {
    private String randomNumber;
    private int strikeCount;
    private int ballCount;
    
    public Game() {
        this.randomNumber = "";
        this.strikeCount = 0;
        this.ballCount = 0;
        
        for (int i=0; i<3; i++) {
            this.randomNumber += Integer.toString(Randoms.pickNumberInRange(1, 9));
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
}

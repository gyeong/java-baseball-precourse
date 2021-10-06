package baseball.domain;

import baseball.utils.CommonUtil;
import nextstep.utils.Randoms;

public class Game {
    private String randomNumber;
    private int strikeCount;
    private int ballCount;
    
    public Game() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.randomNumber = "";
        
        for (int i=0; i<CommonUtil.GAME_INPUT_LENGTH; i++) {
            this.randomNumber += pickRandomNumber(this.randomNumber);
        }
    }
    
    /**
     * 스트라이크 갯수 확인
     */
    public int getStrikeCount() {
        return strikeCount;
    }
    
    /**
     * 볼 갯수 확인
     */
    public int getBallCount() {
        return ballCount;
    }
    
    /**
     * 랜덤 숫자 확인
     */
    public String getRandomNumber() {
        return randomNumber;
    }
    
    /**
     * 랜덤 숫자 임의 설정
     * @param randomNumber
     */
    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
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
    public void setBallCount(int ballCount) {
        if (ballCount == 0) {
            this.ballCount = 0;
            return;
        }
        this.ballCount += ballCount;
    }
    
    /**
     * 게임 결과 산출
     * @param inputNum
     */
    public void getGameResult(String[] inputNum) {
        for (int i=0; i<CommonUtil.GAME_INPUT_LENGTH; i++) {
            compareNumber(inputNum[i], i);
        }
    }
    
    /**
     * 랜덤 숫자와 사용자 입력 숫자 비교
     * @param inputNum
     * @param inputNumIndex
     */
    private void compareNumber(String inputNum, int inputNumIndex) {
        int randomNumIndex = this.randomNumber.indexOf(inputNum);
        
        if (randomNumIndex == inputNumIndex) {
            setStrikeCount(1);
            return;
        }
        
        if (randomNumIndex >= 0 ) {
            setBallCount(1);
        }
    }
    
    /**
     * 올 스트라이크 체크
     */
    public boolean isAllStrike() {
        if (this.strikeCount == CommonUtil.GAME_INPUT_LENGTH) {
            return true;
        }
        
        setStrikeCount(0);
        setBallCount(0);
        
        return false;
    }
    
    /**
     * 랜덤 숫자 중복 체크
     * @param input
     */
    private String pickRandomNumber(String input) {
        String result = "";
        int index = 0;
        
        while (index >= 0) {
            result = Integer.toString(Randoms.pickNumberInRange(
                    CommonUtil.GAME_NUMBER_MIN, CommonUtil.GAME_NUMBER_MAX));
            index = input.indexOf(result);
        }
        
        return result;
    }
}

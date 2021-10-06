package baseball.domain;

import baseball.utils.CommonUtil;
import baseball.utils.MessageUtil;
import baseball.utils.StringUtil;

public class GamePresenter {
    
    /**
     * 사용자 게임 숫자 입력값 유효성 체크
     * 
     * @param input
     */
    public boolean checkValidation(String input) {
        if (!checkNumber(input) || !checkLength(input)) {
            return false;
        }
        
        return true;
    } 
    
    /**
     * 사용자 게임 종료/재시작 입력값 유효성 체크
     * 
     * @param input
     */
    public boolean checkTermValidation(String input) {
        if (!input.equals(CommonUtil.GAME_NUMBER_RESTART) && !input.equals(CommonUtil.GAME_NUMBER_TERMINATE) ) {
            printErrorMsg(MessageUtil.ERROR_INVALID_TERM_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 게임 결과 메시지 출력
     */
    public void printResultMsg(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(MessageUtil.RESULT_NOTHING);
            return;
        }
        
        System.out.println(makeResultMsg(strikeCount, ballCount));
    }

    /**
     * 게임 결과 메시지 생성
     * 
     * @param strikeCount
     * @param ballCount
     */
    private String makeResultMsg(int strikeCount, int ballCount) {
        String resultMsg = "";

        if (strikeCount > 0) {
            resultMsg += strikeCount + MessageUtil.RESULT_STRIKE;
        }
        if (ballCount > 0) {
            resultMsg += ballCount + MessageUtil.RESULT_BALL;
        }

        return resultMsg;
    }

    /**
     * 사용자 숫자 입력값 길이(3자리) 체크
     * 
     * @param input
     */
    private boolean checkLength(String input) {
        if (input.length() != CommonUtil.GAME_INPUT_LENGTH) {
            printErrorMsg(MessageUtil.ERROR_INPUT_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 사용자 숫자 여부 체크
     * 
     * @param input
     */
    private boolean checkNumber(String input) {
        if (!StringUtil.isNumber(input)) {
            printErrorMsg(MessageUtil.ERROR_INPUT_MESSAGE);
            return false;
        }

        if (input.contains(CommonUtil.GAME_NUMBER_ZERO)) {
            printErrorMsg(MessageUtil.ERROR_INVALID_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * 게임 종료 여부 확인
     * 
     * @param input
     */
    public boolean isEnd(String input) {
        if (input.equals(CommonUtil.GAME_NUMBER_TERMINATE)) {
            return true;
        }
        
        return false;
    }
    /**
     * 숫자 입력 안내 메시지 출력
     */
    public void printIntroMsg() {
        System.out.print(MessageUtil.ASK_PICK_NUMBER);
    }
    
    /**
     * 게임 재시작/종료 선택 안내 메시지 출력
     */
    public void printSelectionMsg() {
        System.out.println(MessageUtil.ASK_NEW_GAME);
    }

    /**
     * 게임 성공 메시지 출력
     */
    public void printSuccessMsg() {
        System.out.println(MessageUtil.SUCCESS_MSG);
    }

    /**
     * 에러 메시지 출력
     * 
     * @param errMsg
     */
    public void printErrorMsg(String errMsg) {
        System.out.println(MessageUtil.ERROR_HEAD + errMsg);
    }
}

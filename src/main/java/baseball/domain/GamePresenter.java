package baseball.domain;

import baseball.utils.CommonUtil;
import baseball.utils.StringUtil;

public class GamePresenter {
    public final String FLAG_RESTART = "1";
    public final String FLAG_TERMINATE = "2";

    private final String ASK_PICK_NUMBER = "숫자를 입력해주세요 : ";
    private final String ASK_NEW_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    private final String GAME_STRIKE = "스트라이크 ";
    private final String GAME_BALL = "볼";
    private final String GAME_NOTHING = "낫싱";

    private final String ERROR_HEAD = "[ERROR] ";
    private final String ERROR_INPUT_MESSAGE = "3자리 숫자를 입력해주세요.";
    private final String ERROR_INVALID_NUMBER_MESSAGE = "1부터 9까지의 숫자만 입력해주세요.";

    /**
     * 숫자 입력 안내 메시지 출력
     */
    public void printIntroMsg() {
        System.out.print(ASK_PICK_NUMBER);
    }

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
     * 게임 결과 메시지 출력
     */
    public void printResultMsg(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(GAME_NOTHING);
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
    public String makeResultMsg(int strikeCount, int ballCount) {
        String resultMsg = "";

        if (strikeCount > 0) {
            resultMsg += strikeCount + GAME_STRIKE;
        }
        if (ballCount > 0) {
            resultMsg += ballCount + GAME_BALL;
        }

        return resultMsg;
    }

    /**
     * 게임 재시작/종료 선택 안내 메시지 출력
     */
    public void printSelectionMsg() {
        System.out.println(ASK_NEW_GAME);
    }

    /**
     * 게임 성공 메시지 출력
     */
    public void printSuccessMsg() {
        System.out.println(SUCCESS_MSG);
    }

    /**
     * 에러 메시지 출력
     * 
     * @param errMsg
     */
    public void printErrorMsg(String errMsg) {
        System.out.println(ERROR_HEAD + errMsg);
    }

    /**
     * 사용자 숫자 입력값 길이(3자리) 체크
     * 
     * @param input
     */
    public boolean checkLength(String input) {
        if (input.length() != 3) {
            printErrorMsg(ERROR_INPUT_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 사용자 숫자 여부 체크
     * 
     * @param input
     */
    public boolean checkNumber(String input) {
        if (!StringUtil.isNumber(input)) {
            printErrorMsg(ERROR_INPUT_MESSAGE);
            return false;
        }

        if (input.contains(CommonUtil.GAME_NUMBER_ZERO)) {
            printErrorMsg(ERROR_INVALID_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }
}

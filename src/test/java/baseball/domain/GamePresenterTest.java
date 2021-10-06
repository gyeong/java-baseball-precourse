package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GamePresenterTest {

    @DisplayName("GamePresenter 게임 숫자 validation 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "abc", "1v", "2454", "012", "21"})
    public void checkValidationTest(String input) {
        GamePresenter presenter = new GamePresenter();
        assertFalse(presenter.checkValidation(input), "false");
        assertTrue(presenter.checkValidation("129"), "true");
        
    }
    
    @DisplayName("GamePresenter 게임 재시작/종료 여부 validation 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "abc", "1v", "2454", "012", "21"})
    public void checkTermValidationTest(String input) {
        GamePresenter presenter = new GamePresenter();
        assertFalse(presenter.checkTermValidation(input), "false");
        assertTrue(presenter.checkTermValidation("1"), "true");
        assertTrue(presenter.checkTermValidation("2"), "true");
    }
    
    @DisplayName("GamePresenter 게임 종료 여부 확인 테스트")
    @Test
    public void isEndTest() {
        GamePresenter presenter = new GamePresenter();
        assertFalse(presenter.isEnd("1"), "false");
        assertTrue(presenter.isEnd("2"), "true");
    }
}

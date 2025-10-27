package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.application.CarNameParser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingInputTest {

    @Test
    void 이름에_공백_포함_불가능() {
        assertThatThrownBy(() -> RacingInput.validateInput("po bi,woni,jun"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백");
    }


    @Test
    void 입력_데이터는_비어있을_수_없다() {
        assertThatThrownBy(() -> RacingInput.validateInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력 값이 비어");
    }
}
package racingcar.application;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingParserTest {
    @Test
    void 자동차_이름은_쉼표_구분_정상() {
        List<String> carNames = RacingParser.parseCarNames("pobi,woni,jun");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 쉼표_외_구분자는_예외_처리() {
        assertThatThrownBy(() -> RacingParser.parseCarNames("pobi;woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    void 자동차_이름이_5자_초과면_예외() {
        assertThatThrownBy(() -> RacingParser.parseCarNames("pobipobi,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    void 자동차_이름_중복_불가능() {
        assertThatThrownBy(() -> RacingParser.parseCarNames("pobi,woni,jun,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 자동차_이름에_알파벳이나_숫자가_아닌_문자가_포함되면_예외() {
        assertThatThrownBy(() -> RacingParser.parseCarNames("p@bi,woni,ju^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("알파벳과 숫자로만");
    }

    @Test
    void 자동차_이름은_비어있을_수_없다() {
        assertThatThrownBy(() -> RacingParser.parseCarNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어");
    }
}
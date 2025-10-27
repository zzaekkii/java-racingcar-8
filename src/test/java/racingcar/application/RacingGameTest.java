package racingcar.application;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 가장_멀리_이동한_자동차가_우승() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.move(8);
        pobi.move(8);
        woni.move(8);

        RacingGame game = new RacingGame(List.of(pobi, woni, jun));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(pobi);
    }

    @Test
    void 공동_우승자가_존재할_수_있다() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.move(8);
        pobi.move(8);
        woni.move(8);
        woni.move(8);

        RacingGame game = new RacingGame(List.of(pobi, woni, jun));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(pobi, woni);
    }
}
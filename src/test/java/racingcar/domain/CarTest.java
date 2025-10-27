package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    @Test
    void 숫자가_4이상_들어오면_전진한다() {
        Car car = new Car("pobi");

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(BigInteger.ONE);

        car.move(6);
        assertThat(car.getPosition()).isEqualTo(BigInteger.TWO);
    }

    @Test
    void 숫자가_4미만이면_정지한다() {
        Car car = new Car("pobi");

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(BigInteger.ZERO);
    }
}
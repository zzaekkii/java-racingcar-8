package racingcar.domain;

import java.math.BigInteger;

public class Car {
    private final String name;
    private BigInteger position = BigInteger.ZERO;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number > 4) {
            position = position.add(BigInteger.ONE);;
        }
    }

    public String getName() {
        return name;
    }

    public BigInteger getPosition() {
        return position;
    }
}

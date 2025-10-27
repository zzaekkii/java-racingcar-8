package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void start(BigInteger attemptCount) {
        System.out.println("\n실행 결과");

        for (BigInteger i = BigInteger.ZERO; i.compareTo(attemptCount) < 0; i = i.add(BigInteger.ONE)) {
            race();
            printRoundResult();
        }
    }

    public void race() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + buildDistance(car.getPosition()));
        }
        System.out.println();
    }

    private String buildDistance(BigInteger distance) {
        StringBuilder track = new StringBuilder();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(distance) < 0; i = i.add(BigInteger.ONE)) {
            track.append("-");
        }
        return track.toString();
    }

    public List<String> getWinners() {
        BigInteger maxPosition = cars.stream()
            .map(Car::getPosition)
            .max(Comparator.naturalOrder())
            .orElse(BigInteger.ZERO);

        return cars.stream()
            .filter(car -> car.getPosition().equals(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}

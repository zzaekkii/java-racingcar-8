package racingcar.controller;

import racingcar.application.RacingGame;
import racingcar.application.RacingParser;
import racingcar.domain.Car;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

import java.math.BigInteger;
import java.util.List;

public class RacingController {
    public void run() {
        String carNamesInput = RacingInput.readCarNames();
        List<String> carNames = RacingParser.parseCarNames(carNamesInput);

        String attemptCountInput = RacingInput.readAttemptCount();
        BigInteger attemptCount = RacingParser.parseAttemptCount(attemptCountInput);

        RacingGame racingGame = new RacingGame(
            carNames.stream().map(Car::new).toList()
        );

        racingGame.start(attemptCount);

        List<Car> winners = racingGame.getWinners();
        RacingOutput.printWinners(winners);
    }
}

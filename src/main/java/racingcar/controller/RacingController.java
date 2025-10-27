package racingcar.controller;

import racingcar.application.RacingParser;
import racingcar.view.RacingInput;

import java.math.BigInteger;
import java.util.List;

public class RacingController {
    public void run() {
        String carNamesInput = RacingInput.readCarNames();
        List<String> carNames = RacingParser.parseCarNames(carNamesInput);

        String attemptCountInput = RacingInput.readAttemptCount();
        BigInteger attemptCount = RacingParser.parseAttemptCount(attemptCountInput);


    }
}

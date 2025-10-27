package racingcar.controller;

import racingcar.application.CarNameParser;
import racingcar.view.RacingInput;

import java.util.List;

public class RacingController {
    public void run() {
        String inputData = RacingInput.readCarNames();
        List<String> carNames = CarNameParser.parseCarNames(inputData);


    }
}

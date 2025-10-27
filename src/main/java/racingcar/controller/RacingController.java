package racingcar.controller;

import racingcar.view.RacingInput;

import java.util.List;

public class RacingController {

    private final RacingInput racingInput = new RacingInput();

    public void run() {
        List<String> carNames = racingInput.readCarNames();


    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RacingInput {

    private RacingInput() {

    };

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateInput(input);

        return input;
    }

    public static String readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        validateInput(input);

        return input;
    }

    static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        if (input.contains(" ") || input.contains("\t")) {
            throw new IllegalArgumentException("입력 값에 공백을 포함할 수 없습니다.");
        }
    }
}

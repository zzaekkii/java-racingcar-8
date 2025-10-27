package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingInput {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseCarNames(Console.readLine());
    }

    List<String> parseCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        if (input.contains(" ") || input.contains("\t")) {
            throw new IllegalArgumentException("입력 값에 공백을 포함할 수 없습니다.");
        }

        String[] names = input.split(",");

        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳과 숫자로만 구성할 수 있습니다.");
            }
            if (result.contains(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }

            result.add(name);
        }

        return result;
    }
}

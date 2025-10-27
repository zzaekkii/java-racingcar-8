package racingcar.application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RacingParser {

    private RacingParser() {
    }

    public static List<String> parseCarNames(String input) {
        String[] names = input.split(",");

        List<String> result = new ArrayList<>();
        for (String name : names) {
            validateName(name, result);
            result.add(name);
        }

        return result;
    }

    private static void validateName(String name, List<String> names) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        if (!name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("자동차 이름은 알파벳과 숫자로만 구성할 수 있습니다.");
        }
        if (names.contains(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    public static BigInteger parseAttemptCount(String input) {
        BigInteger count;

        try {
            count = new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        if (count.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

        return count;
    }
}

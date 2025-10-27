package racingcar.view;

import java.util.List;

public class RacingOutput {
    private RacingOutput() {}

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

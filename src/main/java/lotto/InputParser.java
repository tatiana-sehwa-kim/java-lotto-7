package lotto;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<Integer> parseNumbers(String input) {
        validateNotBlank(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputParser::parseInt)
                .toList();
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }
    }

    private static int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}

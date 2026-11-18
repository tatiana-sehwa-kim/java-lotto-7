package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public CheckNumber(String winningNumber, String bonusNumber) {
        List<Integer> parsedWinningNumber = toList(winningNumber);
        int parsedBonusNumber = toNumber(bonusNumber);
        validateBonusDuplicate(parsedWinningNumber, parsedBonusNumber);

        this.winningNumber = parsedWinningNumber;
        this.bonusNumber = parsedBonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> toList(String winningNumber) {
        validateNotBlank(winningNumber);
        String[] tokens = winningNumber.split(",");
        validateSize(tokens);

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(toNumber(token));
        }
        validateDuplicates(numbers);
        return numbers;
    }

    public int toNumber(String input) {
        validateNotBlank(input);
        int number = parseInt(input.trim());
        isValid(number);
        return number;
    }

    public void isValid(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
        }
    }

    private void validateSize(String[] tokens) {
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    // 추가
    public int countMatch(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean isBonusMatch(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }
}
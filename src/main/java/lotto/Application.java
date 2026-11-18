package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = buyLottos();
        List<Lotto> userLottos = lottoMachine.getItems();
        int purchaseAmount = userLottos.size() * 1000;

        CheckNumber checkNumber = readWinningNumbers();
        LottoResult result = new LottoResult(userLottos, checkNumber);

        printStatistics(result, purchaseAmount);
    }

    private static LottoMachine buyLottos() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return new LottoSeller().purchase(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static CheckNumber readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String winningInput = Console.readLine();
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String bonusInput = Console.readLine();
                return new CheckNumber(winningInput, bonusInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printStatistics(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", result.getCount(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", result.getCount(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", result.getCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", result.getCount(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.getCount(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.calculateReturnRate(purchaseAmount));
    }
}
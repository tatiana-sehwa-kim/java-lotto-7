package lotto;

public class LottoSeller {

    private int validateAmount(String orderTotal) {
        if (orderTotal == null || orderTotal.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해야 합니다.");
        }
        int amount = parseInt(orderTotal);  // 변환
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 구매해야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    private int parseInt(String orderTotal) {
        int amount;
        try {
            amount = Integer.parseInt(orderTotal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        return amount;
    }

    public LottoMachine purchase(String orderTotal) {
        int amount = validateAmount(orderTotal);
        int quantity = amount / 1000;
        System.out.println(quantity + "개를 구매했습니다.");

        LottoMachine lottoMachine = new LottoMachine(quantity);
        lottoMachine.printLotto();
        return lottoMachine;
    }
}

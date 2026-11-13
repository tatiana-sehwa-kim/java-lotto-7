package lotto;

public class LottoSeller {

    public void purchaseCalculator(String orderTotal) {
        Integer quantity = Integer.parseInt(orderTotal) / 1000;
        System.out.println(quantity + "개를 구매했습니다.");

        LottoMachine lottoMachine = new LottoMachine(quantity);
    }
}

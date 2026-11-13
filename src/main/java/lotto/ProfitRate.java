package lotto;

public class ProfitRate {

    private double profitRate;

    public void matchingNumber() {
        System.out.println("당첨 통계");
        CheckNumber checkNumber = new CheckNumber();
    }



    @Override
    public String toString() {
        return "총 수익률은 " + this.profitRate + "%입니다.";
    }
}

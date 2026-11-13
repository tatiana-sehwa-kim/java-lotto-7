package lotto;

public class CheckNumber {

    public void calculate() {
        got3Numbers();
        got4Numbers();
        got5Numbers();
        got5NumbersAndBonus();
        got6Numbers();
    }

    public void got3Numbers() {     // 계산
        System.out.println("3개 일치 (5,000) - " + + "개");
    }

    public void got4Numbers() {
        System.out.println("4개 일치 (50,000) - " + + "개");
    }

    public void got5Numbers() {
        System.out.println("5개 일치 (1,500,000) - " + + "개");
    }

    public void got5NumbersAndBonus() {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000) - " + + "개");
    }

    public void got6Numbers() {
        System.out.println("6개 일치 (2,000,000,000) - " + + "개");
    }
}

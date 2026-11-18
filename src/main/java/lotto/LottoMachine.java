package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {    // quantity 만큼 Lotto 객체 생성
    private final List<Lotto> items;

    public LottoMachine(List<Lotto> items) {
        this.items = items;
    }
    public LottoMachine(int count) {
        this.items = generateItems(count);
    }

    private List<Lotto> generateItems(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new Lotto());
        }
        return result;
    }

    public void printLotto() {
        for (Lotto item : items) {
            System.out.println(item);
        }
    }

    public List<Lotto> getItems() {
        return items;
    }
}

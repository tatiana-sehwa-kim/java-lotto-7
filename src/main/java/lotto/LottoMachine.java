package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {    // quantity 만큼 Lotto 객체 생성
    private final List<List<Integer>> items;

    public LottoMachine(List<List<Integer>> items) {
        this.items = items;
    }
    public LottoMachine(int count) {
        this.items = generateItems(count);
    }

    private List<List<Integer>> generateItems(int quantity) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            result.add(new ArrayList<>());
        }
        return result;
    }
}

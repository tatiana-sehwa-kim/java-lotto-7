package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> userLottos, CheckNumber checkNumber) {
        initCounts();
        calculateRanks(userLottos, checkNumber);
    }

    private void initCounts() {
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
    }

    private void calculateRanks(List<Lotto> userLottos, CheckNumber checkNumber) {
        for (Lotto lotto : userLottos) {
            int matchCount = checkNumber.countMatch(lotto);
            boolean matchBonus = checkNumber.isBonusMatch(lotto);
            Rank rank = Rank.of(matchCount, matchBonus);
            counts.put(rank, counts.get(rank) + 1);
        }
    }

    public int getCount(Rank rank) {
        return counts.get(rank);
    }

    public double calculateReturnRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private long calculateTotalPrize() {
        return counts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
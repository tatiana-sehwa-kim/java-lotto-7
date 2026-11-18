package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 1부터 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new CheckNumber("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 번호 개수와 보너스 여부에 따라 정확한 등수를 반환한다.")
    @Test
    void 일치_개수와_보너스_여부로_등수를_판별한다() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(2, true)).isEqualTo(Rank.NONE);
    }

    @DisplayName("구매 금액 대비 당첨금 수익률을 정확히 계산한다.")
    @Test
    void 수익률을_정확히_계산한다() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 5등 (5,000원)
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 꽝 (0원)
        );
        CheckNumber checkNumber = new CheckNumber("1,2,3,4,5,6", "7");
        LottoResult result = new LottoResult(userLottos, checkNumber);

        assertThat(result.calculateReturnRate(8000)).isEqualTo(62.5);
    }
}

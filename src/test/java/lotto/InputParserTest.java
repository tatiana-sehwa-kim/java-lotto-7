package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputParserTest {

    // 패턴1. 정상 작동 검증 (assertThat)
    @DisplayName("쉼표로 구분된 숫자 문자열을 리스틀 변환한다")
    @Test
    void parseNumbers_success() {
        String input = "1, 2, 3, 4, 5, 6";  // given(준비)
        List<Integer> result = InputParser.parseNumbers(input); // when(실행)
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6); // then(검증: 기대하는 결과와 일치하는가?)
    }

    //패턴2. 예외 발생 검증 (assertThatThrownBy)
    @DisplayName("숫자가 아닌 문자가 포함되면 예외가 발생한다")
    @Test
    void parseNumbers_invalidCharacter_throwsException() {
        String input = "1,2,a,4";

        assertThatThrownBy(() -> InputParser.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR}");
    }
}

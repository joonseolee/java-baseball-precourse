package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RangeNumberAnswerMakerStrategyTest {

    @Test
    @DisplayName("generateAnswer 사용할때 기본 3 자리로 세팅되어있을경우 3 사이즈를 가진 랜덤 숫자를 리턴한다.")
    void whenDefaultGenerateAnswer_thenRandomNumberWithThreeLength() {
        AnswerMakerStrategy<Integer> answerMaker = new RangeNumberAnswerMakerStrategy();

        int answer = answerMaker.generateAnswer();

        int currentNumber = answer % 10;
        while (currentNumber > 0) {
            assertThat(currentNumber).isLessThan(10).isPositive();
            answer = answer / 10;
            currentNumber = answer % 10;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("generateAnswer 사용할때 임의로 자릿수를 세팅되어있을경우 임의의 사이즈를 가진 랜덤 숫자를 리턴한다.")
    void whenGenerateAnswer_thenRandomNumberWithThreeLength(int numberSize) {
        AnswerMakerStrategy<Integer> answerMaker = new RangeNumberAnswerMakerStrategy(numberSize);

        int answer = answerMaker.generateAnswer();

        assertThat(String.valueOf(answer)).hasSize(numberSize);
    }
}
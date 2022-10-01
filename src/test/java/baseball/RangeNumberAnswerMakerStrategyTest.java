package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RangeNumberAnswerMakerStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "123:3", "123456789:9"}, delimiter = ':')
    @DisplayName("isCorrectParameter 사용할때 첫번째 인자의 length 가 answerLength 와 동일할경우 참을 리턴한다.")
    void givenSameLength_whenGenerateAnswer_thenTrue(String parameter, int answerLength) {
        ArgumentStrategy answerMaker = new NumberArgumentStrategy();

        assertThat(answerMaker.isCorrectParameter(parameter, answerLength)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "123:1", "123456789:12"}, delimiter = ':')
    @DisplayName("isCorrectParameter 사용할때 첫번째 인자의 length 가 answerLength 와 동일하지않을경우 참을 리턴한다.")
    void givenNotSameLength_whenGenerateAnswer_thenFalse(String parameter, int answerLength) {
        ArgumentStrategy answerMaker = new NumberArgumentStrategy();

        assertThat(answerMaker.isCorrectParameter(parameter, answerLength)).isFalse();
    }
}
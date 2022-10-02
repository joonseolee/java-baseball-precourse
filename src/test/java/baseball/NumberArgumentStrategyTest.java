package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberArgumentStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "123:3", "123456789:9"}, delimiter = ':')
    @DisplayName("checkCorrectParameter 사용할때 첫번째 인자의 length 가 answerLength 와 동일할경우 정상적으로 동작한다.")
    void givenSameLength_whenCheckCorrectParameter_thenTrue(String parameter, int answerLength) {
        ArgumentStrategy answerMaker = new NumberArgumentStrategy();

        answerMaker.checkCorrectParameter(parameter, answerLength);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "123:1", "123456789:12"}, delimiter = ':')
    @DisplayName("checkCorrectParameter 사용할때 첫번째 인자의 length 가 answerLength 와 동일하지않을경우 에러를 던진다.")
    void givenNotSameLength_whenCheckCorrectParameter_thenFalse(String parameter, int answerLength) {
        ArgumentStrategy answerMaker = new NumberArgumentStrategy();

        assertThatThrownBy(() -> answerMaker.checkCorrectParameter(parameter, answerLength))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
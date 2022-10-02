package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameAnswerMatcherStrategyTest {

    private AnswerMatcherStrategy answerMatcherStrategy;
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        this.answerMatcherStrategy = new BaseballGameAnswerMatcherStrategy();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @CsvSource(value = {"123:412", "123:456", "123:123", "123:213"}, delimiter = ':')
    void whenDrawConclusion_thenPrintText(String answer, String userAnswer) {
        answerMatcherStrategy.drawConclusion(answer, userAnswer);

        assertThat(outputStreamCaptor.toString().trim()).containsAnyOf("낫싱", "2볼", "3스트라이크", "2볼 1스트라이크");
    }
}
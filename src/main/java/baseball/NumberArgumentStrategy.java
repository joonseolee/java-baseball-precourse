package baseball;

import java.util.Objects;
import java.util.regex.Pattern;

public class NumberArgumentStrategy implements ArgumentStrategy {
    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public void checkCorrectParameter(String parameter, int answerLength) {
        if (Objects.isNull(parameter) || parameter.length() == 0) {
            throw new IllegalArgumentException();
        }

        if (parameter.length() != answerLength) {
            throw new IllegalArgumentException();
        }

        boolean isCorrect = pattern.matcher(parameter).matches();

        if (!isCorrect) {
            throw new IllegalArgumentException();
        }
    }
}

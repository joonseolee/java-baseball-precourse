package baseball;

import java.util.Objects;
import java.util.regex.Pattern;

public class NumberArgumentStrategy implements ArgumentStrategy {
    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public boolean isCorrectParameter(String parameter, int answerLength) {
        if (Objects.isNull(parameter) || parameter.length() == 0) {
            return false;
        }

        if (parameter.length() != answerLength) {
            return false;
        }

        return pattern.matcher(parameter).matches();
    }
}

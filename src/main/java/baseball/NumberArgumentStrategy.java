package baseball;

import java.util.regex.Pattern;

public class NumberArgumentStrategy implements ArgumentStrategy {
    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public void checkCorrectParameter(String parameter, int answerLength) {
        checkNullOrEmpty(parameter);
        checkSameLength(parameter, answerLength);
        checkNumberText(parameter);
    }

    private void checkNullOrEmpty(String parameter) {
        if (parameter == null || parameter.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSameLength(String parameter, int answerLength) {
        if (parameter.length() != answerLength) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberText(String parameter) {
        boolean isCorrect = pattern.matcher(parameter).matches();

        if (!isCorrect) {
            throw new IllegalArgumentException();
        }
    }
}

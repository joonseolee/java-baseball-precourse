package baseball;

public class BaseballGameAnswerMatcherStrategy implements AnswerMatcherStrategy {

    @Override
    public void drawConclusion(String answer, String userAnswer) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int index = 0 ; index < answer.length() ; index++) {
            String textExceptCurrentIndexCharacter = answer.replace(String.valueOf(answer.charAt(index)), StringConstant.EMPTY);
            ballCount += calculateBallCount(textExceptCurrentIndexCharacter, userAnswer.charAt(index));
            strikeCount += calculateStrikeCount(answer.charAt(index), userAnswer.charAt(index));
        }

        printUserScore(ballCount, strikeCount);
    }

    private int calculateBallCount(String rawCurrentAnswer, char charAt) {
        int index = rawCurrentAnswer.indexOf(charAt);

        if (index > -1) {
            return 1;
        }

        return 0;
    }

    private int calculateStrikeCount(char answerCharacter, char userAnswerCharacter) {
        if (answerCharacter == userAnswerCharacter) {
            return 1;
        }

        return 0;
    }

    private void printUserScore(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        String ballText = printEachScoreText(ballCount, "볼");
        String strikeText = printEachScoreText(strikeCount, "스트라이크");
        if (!ballText.equals(StringConstant.EMPTY) && !strikeText.equals(StringConstant.EMPTY)) {
            ballText = ballText + StringConstant.ONE_SPACE;
        }
        System.out.println(ballText + strikeText);
    }

    private String printEachScoreText(int ballCount, String suffixText) {
        if (ballCount == 0) {
            return StringConstant.EMPTY;
        }

        return ballCount + suffixText;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RangeNumberAnswerMakerStrategy implements AnswerMakerStrategy<Integer> {
    private static final int ANSWER_START_RANGE = 1;
    private static final int ANSWER_END_RANGE = 9;
    private static final int DEFAULT_ANSWER_SIZE = 3;

    private final int answerSize;

    @Override
    public Integer generateAnswer() {
        StringBuilder answer = new StringBuilder();

        for (int index = 0 ; index < this.answerSize ; index++) {
            int number = Randoms.pickNumberInRange(ANSWER_START_RANGE, ANSWER_END_RANGE);
            answer.append(number);
        }

        return Integer.parseInt(answer.toString());
    }

    public RangeNumberAnswerMakerStrategy() {
        this.answerSize = DEFAULT_ANSWER_SIZE;
    }

    public RangeNumberAnswerMakerStrategy(int answerSize) {
        this.answerSize = answerSize;
    }
}

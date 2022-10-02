package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RangeNumberAnswerMakerStrategy implements AnswerMakerStrategy<Integer> {
    private static final int ANSWER_START_RANGE = 1;
    private static final int ANSWER_END_RANGE = 9;
    private static final int DEFAULT_ANSWER_SIZE = 3;

    private final int answerSize;

    @Override
    public Integer generateAnswer() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != this.answerSize) {
            int uniqueNumber = generateUniqueNumber(numbers, Randoms.pickNumberInRange(ANSWER_START_RANGE, ANSWER_END_RANGE));
            numbers.add(uniqueNumber);
        }

        return toAnswerInteger(numbers);
    }

    private int generateUniqueNumber(List<Integer> numbers, int randomNumber) {
        if (numbers.contains(randomNumber)) {
            return generateUniqueNumber(numbers, Randoms.pickNumberInRange(ANSWER_START_RANGE, ANSWER_END_RANGE));
        }

        return randomNumber;
    }

    private Integer toAnswerInteger(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0 ; index < numbers.size() ; index++) {
            builder.append(numbers.get(index));
        }

        return Integer.parseInt(builder.toString());
    }

    @Override
    public int getAnswerSize() {
        return answerSize;
    }

    public RangeNumberAnswerMakerStrategy() {
        this.answerSize = DEFAULT_ANSWER_SIZE;
    }

    public RangeNumberAnswerMakerStrategy(int answerSize) {
        this.answerSize = answerSize;
    }
}

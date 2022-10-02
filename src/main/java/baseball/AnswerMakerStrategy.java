package baseball;

public interface AnswerMakerStrategy<T> {

    T generateAnswer();

    int getAnswerSize();
}

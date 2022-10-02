package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameMachine {
    private static final String REPLAY_COMMAND = "1";
    private static final int INITIAL_USER_ANSWER = -1;

    private final AnswerMakerStrategy<Integer> answerMakerStrategy;
    private final AnswerMatcherStrategy answerMatcherStrategy;
    private int currentAnswer;

    public BaseballGameMachine() {
        this.answerMakerStrategy = new RangeNumberAnswerMakerStrategy();
        this.answerMatcherStrategy = new BaseballGameAnswerMatcherStrategy(new NumberArgumentStrategy());
    }

    public void start() {
        initCurrentAnswer();
        playGame();
        askMoreGame();
    }

    private void initCurrentAnswer() {
        this.currentAnswer = answerMakerStrategy.generateAnswer();
    }

    private void playGame() {
        int userAnswer = INITIAL_USER_ANSWER;
        while (this.currentAnswer != userAnswer) {
            String rawUserAnswer = Console.readLine();
            answerMatcherStrategy.drawConclusion(String.valueOf(currentAnswer), rawUserAnswer);

            userAnswer = Integer.parseInt(rawUserAnswer);
        }

        System.out.println(answerMakerStrategy.getAnswerSize() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void askMoreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userAnswer = Console.readLine();

        if (userAnswer.equals(REPLAY_COMMAND)) {
            start();
        }
    }
}

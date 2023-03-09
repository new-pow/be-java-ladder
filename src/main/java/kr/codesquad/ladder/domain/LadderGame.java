package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.view.InputView;
import kr.codesquad.ladder.view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderGame {
    private Ladder ladder;
    private Users users;
    private InputView inputView;
    private OutputView outputView;

    public LadderGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            users = new Users(inputView.getUserNames());
            int lineNum = inputView.getStepNum();

            ladder = new Ladder(users.size(), lineNum);

            outputView.printLadder(ladder, users);

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}

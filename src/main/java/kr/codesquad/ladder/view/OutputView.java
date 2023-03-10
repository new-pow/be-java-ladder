package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.Users;

import java.util.List;

public class OutputView {

    private final String LADDER_BAR = "|";
    private final String NEW_LINE = System.lineSeparator();
    private StringBuilder stringBuilder;

    public OutputView() {
        stringBuilder = new StringBuilder();
    }

    public void printLadder(Ladder ladder , Users users) {
        printUserNames(users);
        stringBuilder.append(NEW_LINE);
        printLadderForm(ladder);
        System.out.println(stringBuilder.toString());
    }

    private void printLadderForm(Ladder ladder) {
        for (int i = 0; i< ladder.getNumStep(); i++) {
            stringBuilder.append(LADDER_BAR);
            getStringLadderALine(ladder.getAStep(i));
            stringBuilder.append(NEW_LINE);
        }
    }

    private void printUserNames(Users users) {
        stringBuilder.append(users.getUserName(0));

        for (int i = 1; i< users.size(); i++) {
            stringBuilder.append(String.format("%6s", users.getUserName(i)));
        }
    }

    private void getStringLadderALine(Line step) {
        for (int j = 0; j< step.size(); j++) {
            stringBuilder.append(step.getValidBridge(j)).append(LADDER_BAR);
        }
    }

    public void print(String result) {
        System.out.println(result + System.lineSeparator());
    }
}

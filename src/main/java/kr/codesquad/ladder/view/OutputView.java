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

    public void printLadder(Ladder ladder , List<String> users, List<String> results) {
        printPoint(users);
        printLadderForm(ladder);
        printPoint(results);
        System.out.println(stringBuilder.toString());
    }

    private void printLadderForm(Ladder ladder) {
        stringBuilder.append(NEW_LINE);
        for (int i = 0; i< ladder.getNumStep(); i++) {
            getStringLadderALine(ladder.getAStep(i));
            stringBuilder.append(NEW_LINE);
        }
    }

    private void printPoint(List<String> points) {
        stringBuilder.append(points.get(0));

        for (int i = 1; i< points.size(); i++) {
            stringBuilder.append(String.format("%6s", points.get(i)));
        }
    }

    private void getStringLadderALine(Line step) {
        stringBuilder.append(LADDER_BAR);
        for (int j = 0; j< step.size(); j++) {
            stringBuilder.append(step.getValidBridge(j)).append(LADDER_BAR);
        }
    }

    public void print(String result) {
        System.out.println(result + System.lineSeparator());
    }
}

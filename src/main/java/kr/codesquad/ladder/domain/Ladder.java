package kr.codesquad.ladder.domain;

import java.util.List;

public class Ladder {
    private List<Line> lines;

    private final int MAX_LINE_NUM = 100000;
    private final int MIN_LINE_NUM = 1;


    public int getNumStep() {
        return lines.size();
    }

    public Ladder(int userNum, int lineNum) {
        this.lines = generateStep(userNum-1, lineNum);
    }

    private List<Line> generateStep(int userNum, int lineNum) {
        isValidLineNum(lineNum);
        return LadderMaker.generate(userNum, lineNum);
    }

    public Line getAStep(int i) {
        return lines.get(i);
    }

    private void isValidLineNum (int lineNum) {
        if (lineNum > MAX_LINE_NUM || lineNum <MIN_LINE_NUM) {
            throw new IllegalArgumentException(String.format("[exception] 사다리 단계는 %d~%d 범위 내여야 합니다.", MIN_LINE_NUM, MAX_LINE_NUM));
        }
    }
}

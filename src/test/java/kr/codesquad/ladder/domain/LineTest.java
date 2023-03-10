package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.util.RandomBoolean;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    Line line;
    RandomBoolean randomBoolean;

    @Test
    @DisplayName("Line 생성자에 List<Boolean>이 삽입되었을 때 그 개수만큼 line이 생성")
    public void initLineTest () {
        randomBoolean = new RandomBoolean(() -> List.of(true, false, true));
        List<Boolean> booleanList = randomBoolean.generate();
        line = new Line(booleanList);
        assertThat(line.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("다리가 옆자리에 연속으로 생성되었을 때, 예외가 발생되어야 한다.")
    public void lineExceptionTest() {
        randomBoolean = new RandomBoolean(() -> List.of(true, true, false));
        List<Boolean> booleanList = randomBoolean.generate();
        assertThatThrownBy(() -> new Line(booleanList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[exception] 다리 생성 오류");
    }

    @Test
    @DisplayName("시작 지점을 입력했을 때, 다리가 있는 방향을 판별하여 도착지점 왼쪽(-1)을 반환")
    public void getNextLineIndexTestLeft() {
        randomBoolean = new RandomBoolean(() -> List.of(true, false, true));
        List<Boolean> generate = randomBoolean.generate();

        line = new Line(generate);
        int start = 1;
        assertThat(line.getNextLineIndex(start)).isEqualTo(-1);
    }

    @Test
    @DisplayName("시작 지점을 입력했을 때, 다리가 있는 방향을 판별하여 도착지점 오른쪽(+1)반환")
    public void getNextLineIndexTestRight() {
        randomBoolean = new RandomBoolean(() -> List.of(false, true, false));
        List<Boolean> generate = randomBoolean.generate();

        line = new Line(generate);
        int start = 1;
        assertThat(line.getNextLineIndex(start)).isEqualTo(+1);
    }

    @Test
    @DisplayName("0에서 시작했을 때, 예외 발생 안함")
    public void getNextLineIndexTestInputZero() {
        randomBoolean = new RandomBoolean(() -> List.of(false, true, false));
        List<Boolean> generate = randomBoolean.generate();

        line = new Line(generate);
        int start = 0;
        assertThat(line.getNextLineIndex(start)).isEqualTo(0);
    }

    @Test
    @DisplayName("최대 인덱스에서 시작했을 때, 예외 발생 안함")
    public void getNextLineIndexTestInputMax() {
        randomBoolean = new RandomBoolean(() -> List.of(false, true, false));
        List<Boolean> generate = randomBoolean.generate();

        line = new Line(generate);
        int start = generate.size()-1;
        assertThat(line.getNextLineIndex(start)).isEqualTo(-1);
    }
}

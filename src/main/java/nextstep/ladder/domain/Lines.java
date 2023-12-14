package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Integer proceedLines(int startIndex) {
        int index = startIndex;
        for (Line line : lines) {
            index = line.proceedLine(index);
        }
        return index;
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public int size() {
        return this.lines.size();
    }
}

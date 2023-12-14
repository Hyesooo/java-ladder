package nextstep.ladder.domain;

import nextstep.ladder.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Players players;
    private final List<Line> lines;
    private final List<String> prizes;

    public Ladder(Players players, List<Line> lines, List<String> prizes) {
        this.players = players;
        this.lines = lines;
        this.prizes = prizes;
    }

    public List<ResultDto> run() {
        List<ResultDto> resultDtoList = players.run(this.lines);
        return resultDtoList.stream()
                .map(resultDto -> {
                    resultDto.setPrize(prizes.get(resultDto.resultIdx));
                    return resultDto;
                })
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public String toStringResult() {
        StringBuilder result = new StringBuilder();

        result.append(players.toStringPlayers()
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        result.append("\n");

        for (Line line : this.lines) {
            result.append(line.toString());
        }

        result.append(this.prizes
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        return result.toString();

    }
}

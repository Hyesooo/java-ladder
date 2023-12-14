package nextstep.ladder.domain;

import nextstep.ladder.ResultDto;

import java.util.List;

public class Player {
    public static int MAX_PLAYER_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException("최대 5자까지 입력가능합니다." + name);
        }
        this.name = name;
    }

    public String toStringName() {
        return name;
    }

    public ResultDto moveLine(int startIndex, List<Line> lines) {
        int index = startIndex;
        for (Line line : lines) {
            index = line.proceedLine(index);
        }
        return new ResultDto(this.name, index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

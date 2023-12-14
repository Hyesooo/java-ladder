package nextstep.ladder.domain;

import nextstep.ladder.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players fromString(List<String> playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return new Players(playerNames.stream().map(Player::new).collect(Collectors.toList()));
    }

    public List<String> toStringPlayers() {
        return players.stream().map(Player::toStringName).collect(Collectors.toList());
    }

    public List<ResultDto> run(List<Line> lines) {
        List<ResultDto> resultDtos = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            resultDtos.add(players.get(i).moveLine(i, lines));
        }
        return resultDtos;
    }
}

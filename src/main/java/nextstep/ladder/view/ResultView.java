package nextstep.ladder.view;

import nextstep.ladder.ResultDto;
import nextstep.ladder.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toStringResult());
    }

    public static void printResultPerPlayer(List<ResultDto> results, String name) {
        if ("all".equals(name)) {
            printAllPlayersResults(results);
        } else {
            printSpecificPlayerResult(results, name);
        }
    }

    private static void printAllPlayersResults(List<ResultDto> results) {
        String allResults = results.stream()
                .map(resultDto -> resultDto.playerName + " : " + resultDto.prize)
                .collect(Collectors.joining("\n"));
        System.out.println(allResults);
    }

    private static void printSpecificPlayerResult(List<ResultDto> results, String name) {
        ResultDto dto = results.stream()
                .filter(resultDto -> resultDto.playerName.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 참가자입니다."));

        System.out.println(dto.playerName + " : " + dto.prize);
    }
}

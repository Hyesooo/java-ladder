package nextstep.ladder.step4.domain.ladder;

import java.util.Map;

public class LadderResult {

    private final Map<Integer, Integer> ladderResult;

    public LadderResult(Map<Integer, Integer> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Integer get(int key) {
        return ladderResult.get(key);
    }

    public int size() {
        return ladderResult.size();
    }
}

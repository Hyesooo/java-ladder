package nextstep.ladder;

public class ResultDto {
    public String playerName;
    public Integer resultIdx;
    public String prize;

    public ResultDto(String playerName, Integer resultIdx) {
        this.playerName = playerName;
        this.resultIdx = resultIdx;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}

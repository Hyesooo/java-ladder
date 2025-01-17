package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public List<String> inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요).");
        return List.of(scanner.nextLine().replaceAll(" ", "").split(","));
    }

    public int inputLadderHeight() {
        System.out.println("사다리 높이는 몇개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거
        return height;
    }

    public List<String> inputResult() {
        System.out.println("결과를 입력하세요. (이름은 쉼표(,)로 구분하세요).");
        return List.of(scanner.nextLine().replaceAll(" ", "").split(","));
    }

    public String inputPlayerForResult() {
        System.out.println("결과를 보고 싶은 참가자를 입력하세요.");
        return scanner.nextLine();
    }
}

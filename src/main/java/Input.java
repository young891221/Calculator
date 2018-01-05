import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import enums.Operator;

public class Input {
    private Scanner scanner;

    public Input(String... testCase) {
        scanner = (testCase.length == 0)
                ? new Scanner(System.in)
                : new Scanner(String.valueOf(testCase[0]));
    }

    public List checkReturnList() {
        List<String> result = new ArrayList<>();
        int i = 0, check = 1;

        while(scanner.hasNext()) {
            String target = scanner.next();
            if("=".equals(target)) break;
            result.add(target);

            if(check++ % 2 == 0) { //짝수
                int finalI = i;
                Arrays.stream(Operator.values()).filter(o -> o.matchOperator(result.get(finalI))).findAny().orElseThrow(NumberFormatException::new);
            }
            else { //홀수
                try {
                    Integer.parseInt(result.get(i));
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
            }
            i++;
        }

        return result;
    }
}

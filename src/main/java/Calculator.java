import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    public static int firstMultiplyAndDivision(List<String> dinamicArr) {
        forLoop(dinamicArr, Operator.MULTIPLY, Operator.DIVISION);
        forLoop(dinamicArr, Operator.PLUS, Operator.MINUS);

        return Integer.parseInt(dinamicArr.get(0));
    }

    private static void forLoop(List<String> dinamicArr, Operator operator1, Operator operator2) {
        for (int i = 0; i < dinamicArr.size(); i++) {
            String target = dinamicArr.get(i);

            if (operator1.matchOperator(target)) {
                i = calculateByOperator(dinamicArr, i, operator1);
            } else if (operator2.matchOperator(target)) {
                i = calculateByOperator(dinamicArr, i, operator2);
            }
        }
    }

    private static int calculateByOperator(List<String> dinamicArr, int i, Operator multiply) {
        String target = String.valueOf(multiply.apply(Integer.valueOf(dinamicArr.get(i - 1)), Integer.valueOf(dinamicArr.get(i + 1))));
        dinamicArr.set(i - 1, target);
        IntStream.range(0, 2).forEach(o -> dinamicArr.remove(i));

        return i - 1;
    }
}

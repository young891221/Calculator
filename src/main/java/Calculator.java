import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    public static List<String> firstBracket(List<String> dynamicArr) {
        for (int i = 0; i < dynamicArr.size(); i++) {
            String target = dynamicArr.get(i);

            if(Bracket.PREV.isEquals(target)) {
                List<String> bracketList = new ArrayList<>();
                int j;
                for (j = i+1; i < dynamicArr.size(); j++) {
                    String subtarget = dynamicArr.get(j);
                    if(Bracket.POST.isEquals(subtarget)) break;
                    bracketList.add(subtarget);
                }
                switchListElement(dynamicArr, i, j, String.valueOf(firstMultiplyAndDivision(bracketList)));
            }
        }

        return dynamicArr;
    }

    public static int firstMultiplyAndDivision(List<String> dynamicArr) {
        forLoop(dynamicArr, Operator.MULTIPLY, Operator.DIVISION);
        forLoop(dynamicArr, Operator.PLUS, Operator.MINUS);

        return Integer.parseInt(dynamicArr.get(0));
    }

    private static void forLoop(List<String> dynamicArr, Operator operator1, Operator operator2) {
        for (int i = 0; i < dynamicArr.size(); i++) {
            String target = dynamicArr.get(i);

            if (operator1.matchOperator(target)) {
                i = calculateByOperator(dynamicArr, i, operator1);
            } else if (operator2.matchOperator(target)) {
                i = calculateByOperator(dynamicArr, i, operator2);
            }
        }
    }

    private static int calculateByOperator(List<String> dynamicArr, int i, Operator multiply) {
        String target = String.valueOf(multiply.apply(Integer.valueOf(dynamicArr.get(i - 1)), Integer.valueOf(dynamicArr.get(i + 1))));
        switchListElement(dynamicArr, i-1, 2, target);

        return i - 1;
    }

    private static void switchListElement(List<String> dynamicArr, int i, int range, String target) {
        int finalI = i+1;
        dynamicArr.set(i, target);
        IntStream.range(0, range).forEach(o -> dynamicArr.remove(finalI));
    }
}

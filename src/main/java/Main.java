import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static int run(Scanner scan) {
        init();
        int result = 0;

        try {
            result = logic(scan);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("형식을 올바르게 맞춰주세요.");
        }

        return result;
    }

    private static void init() {
        System.out.println("계산기입니다.");
        System.out.println("원하는 연산을 입력해 주세요.");
        System.out.println("예)숫자 연산 숫자(3 + 3 = )");
    }

    private static int logic(Scanner scan) {
        boolean isFirst = true;
        int previous = 0;

        while (scan.hasNext()) {
            if(isFirst) previous = scan.nextInt();
            String operator = scan.next();
            if(operator.equals("=")) break;
            int input = scan.nextInt();

            //String 형식으로 배열로 갖고 있고, 괄호 따로 곱하기/나누기부터 찾아서 왼쪽부터 계산하는 함수, 계산된 수들을 다시 배열에 재배열, 왼쪽부터 연산
            Optional<Operator> matchOperator = Arrays.stream(Operator.values()).filter(o -> o.matchOperator(operator)).findAny();
            matchOperator.orElseThrow(NumberFormatException::new);
            previous = matchOperator.get().apply(previous, input);

            isFirst = false;
        }

        scan.close();
        System.out.println(previous);
        return previous;
    }

    //Calculator 클래스로 별도로 분리할 것
    public Object firstMultiplyAndDivision(String[] arr) {
        List<String> dinamicArr = new ArrayList<>(Arrays.asList(arr));
        int result = 0;

        for(int i = 0; i < dinamicArr.size(); i++) {
            String target = dinamicArr.get(i);

            if(Operator.MULTIPLY.matchOperator(target)) {
                target = String.valueOf(Operator.MULTIPLY.apply(Integer.valueOf(dinamicArr.get(i-1)), Integer.valueOf(dinamicArr.get(i+1))));

                dinamicArr.set(i-1, target);
                dinamicArr.remove(i);
                dinamicArr.remove(i);
                i -= 1;
            }
            else if(Operator.DIVISION.matchOperator(target)) {
                target = String.valueOf(Operator.MULTIPLY.apply(Integer.valueOf(dinamicArr.get(i-1)), Integer.valueOf(dinamicArr.get(i+1))));

                dinamicArr.set(i-1, target);
                dinamicArr.remove(i - 1);
                dinamicArr.remove(i);
                i -= 1;
            }
        }

        for(int i = 0, l = dinamicArr.size(); i < l; i++) {
            String target = dinamicArr.get(i);

            if(Operator.PLUS.matchOperator(target)) {
                result += Operator.PLUS.apply(Integer.valueOf(dinamicArr.get(i-1)), Integer.valueOf(dinamicArr.get(i+1)));

                dinamicArr.set(i-1, String.valueOf(result));
                dinamicArr.remove(i);
                dinamicArr.remove(i);
                i -= 1;
            }
            else if(Operator.MINUS.matchOperator(target)) {
                result += Operator.MINUS.apply(Integer.valueOf(dinamicArr.get(i-1)), Integer.valueOf(dinamicArr.get(i+1)));

                dinamicArr.set(i-1, String.valueOf(result));
                dinamicArr.remove(i);
                dinamicArr.remove(i);
                i -= 1;
            }

        }

        return result;
    }

}

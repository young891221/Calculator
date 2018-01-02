import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        init();

        Scanner scan = new Scanner(System.in);
        int previous = 0;
        boolean isFirst = true;

        try {
            logic(scan, previous, isFirst);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("형식을 올바르게 맞춰주세요.");
        }
    }

    private static void init() {
        System.out.println("계산기입니다.");
        System.out.println("원하는 연산을 입력해 주세요.");
        System.out.println("예)숫자 연산 숫자(3 + 3 = )");
    }

    private static void logic(Scanner scan, int previous, boolean isFirst) {
        while (scan.hasNext()) {
            if (isFirst) previous = scan.nextInt();
            String operator = scan.next();
            if(operator.equals("=")) break;
            int input = scan.nextInt();

            Optional<Operator> matchOperator = Arrays.stream(Operator.values()).filter(o -> o.matchOperator(operator)).findAny();
            matchOperator.orElseThrow(NumberFormatException::new);
            previous = matchOperator.get().apply(previous, input);

            isFirst = false;
        }
        scan.close();
        System.out.println(previous);
    }
}

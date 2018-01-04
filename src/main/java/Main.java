import java.util.Arrays;
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

            //올바르게 입력됐는지 먼저 체크해야됨
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

}

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(run(new Scanner(System.in)));
    }

    public static int run(Scanner scan) {
        init();
        int result = 0;
        Input input = new Input();
        Calculator calculator = new Calculator();

        try {
            List<String> list = input.checkReturnList();
            result = calculator.firstMultiplyAndDivision(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("형식을 올바르게 맞춰주세요.");
        }

        return result;
    }

    private static void init() {
        System.out.println("계산기입니다.");
        System.out.println("원하는 연산을 입력해 주세요.");
        System.out.println("예)숫자 연산 숫자(3 + 3  * 4 = )");
    }

}

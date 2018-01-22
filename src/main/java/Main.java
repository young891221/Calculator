import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(run());
    }

    public static Object run() {
        init();
        int result;

        try {
            List<String> list = new Input(System.in).checkReturnList();
            result = Calculator.firstMultiplyAndDivision(list);
        } catch (Exception e) {
            return "형식을 올바르게 맞춰주세요.";
        }

        return result;
    }

    private static void init() {
        System.out.println("계산기입니다.");
        System.out.println("원하는 연산을 입력해 주세요.");
        System.out.println("예)숫자 연산 숫자(3 + 3  * 4 = )");
    }

}

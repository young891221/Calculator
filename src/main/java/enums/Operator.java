package enums;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String operator;
    private BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public int apply(int a, int b) {
        return this.function.apply(a, b);
    }

    public boolean matchOperator(String operator) {
        return this.operator.equals(operator);
    }

    public String getValue() { return this.operator; }

}

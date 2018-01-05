package enums;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(int a, int b) { return a + b; }
    },
    MINUS("-") {
        @Override
        public int apply(int a, int b) { return a - b; }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int a, int b) { return a * b; }
    },
    DIVISION("/") {
        @Override
        public int apply(int a, int b) { return a / b; }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public boolean matchOperator(String operator) {
        return this.operator.equals(operator);
    }

    public String getValue() { return this.operator; }

    public abstract int apply(int a, int b);
}

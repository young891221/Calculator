public enum Operator {
    PLUS("+") {
        @Override
        int apply(int a, int b) { return a + b; }
    },
    MINUS("-") {
        @Override
        int apply(int a, int b) { return a - b; }
    },
    MULTIPLY("*") {
        @Override
        int apply(int a, int b) { return a * b; }
    },
    DIVISION("/") {
        @Override
        int apply(int a, int b) { return a / b; }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public boolean matchOperator(String operator) {
        return this.operator.equals(operator);
    }

    abstract int apply(int a, int b);
}

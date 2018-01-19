package enums;

public enum Bracket {
    PREV("("),
    POST(")");

    private String value;

    Bracket(String value) {
        this.value = value;
    }

    public boolean isEqualTarget(String target) {
        return value.equals(target);
    }
}

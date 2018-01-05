package enums;

public enum Bracket {
    PREV("("),
    POST(")");

    private String value;

    Bracket(String value) {
        this.value = value;
    }

    public boolean isEquals(String target) {
        return value.equals(target);
    }
}

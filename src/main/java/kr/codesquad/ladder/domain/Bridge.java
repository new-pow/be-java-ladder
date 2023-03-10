package kr.codesquad.ladder.domain;

public enum Bridge {
    BRIDGE("------"), EMPTY("      ");

    private final String FORM;

    Bridge(String form) {
        this.FORM = form;
    }

    public static Bridge of(boolean plan) {
        if (plan) {
            return BRIDGE;
        }
        return EMPTY;
    }

    @Override
    public String toString() {
        return FORM;
    }
}

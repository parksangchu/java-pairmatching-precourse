package pairmatching.domain;

public enum Error {
    INVALID_INPUT("잘못된 입력입니다.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}

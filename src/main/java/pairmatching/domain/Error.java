package pairmatching.domain;

public enum Error {
    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_FILE("파일을 불러오는 중 오류가 발생했습니다."),
    INVALID_CONDITION("매칭 이력이 없습니다.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}

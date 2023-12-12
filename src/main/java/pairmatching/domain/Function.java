package pairmatching.domain;

public enum Function {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_INQUIRY("2", "페어 조회"),
    PAIR_INITIALIZATION("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String value;
    private final String name;

    Function(String value, String name) {
        this.value = value;
        this.name = name;
    }

}

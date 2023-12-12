package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_INPUT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Function> functions() {
        return Collections.unmodifiableList(
                Arrays.stream(values())
                        .collect(Collectors.toList()));
    }

    public static Function of(String value) {
        return Arrays.stream(values())
                .filter(function ->
                        function.value
                                .equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.getMessage()));
    }

    public boolean isQuit() {
        return this == QUIT;
    }

    public boolean isPairMatching() {
        return this == PAIR_MATCHING;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

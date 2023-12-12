package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_INPUT;

import java.util.Arrays;

public enum ReMatching {
    YES("네"),
    NO("아니오");

    private final String answer;

    ReMatching(String answer) {
        this.answer = answer;
    }

    public static ReMatching of(String answer) {
        return Arrays.stream(values())
                .filter(reMatching ->
                        reMatching.answer
                                .equals(answer))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.getMessage()));
    }

    public boolean isYes() {
        return this == YES;
    }
}

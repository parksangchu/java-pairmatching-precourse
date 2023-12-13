package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_INPUT;

import java.util.Arrays;

public enum Mission {
    RACING_GAME("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL_GAME("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_ROUTE_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTION("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String name) {
        return Arrays.stream(values())
                .filter(course
                        -> course.name
                        .equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.getMessage()));
    }

    public String getName() {
        return name;
    }
}

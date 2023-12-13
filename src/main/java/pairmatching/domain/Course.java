package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static List<Course> courses() {
        return Arrays.stream(values())
                .collect(Collectors.toList());
    }

    public static Course of(String name) {
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

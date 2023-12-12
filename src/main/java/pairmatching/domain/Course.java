package pairmatching.domain;

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

    public String getName() {
        return name;
    }
}

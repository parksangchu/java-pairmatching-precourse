package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Condition {
    private static final String DELIMITER = ",";
    private final Course course;
    private final Level level;
    private final Mission mission;

    public Condition(String condition) {
        course = initCourse(condition);
        Level level = initLevel(condition);
        Mission mission = initMission(condition);
        validate(level, mission);
        this.level = level;
        this.mission = mission;
    }

    private Course initCourse(String condition) {
        String name = separate(condition).get(0);
        return Course.of(name);
    }

    private Level initLevel(String condition) {
        String name = separate(condition).get(1);
        return Level.of(name);
    }

    private Mission initMission(String condition) {
        String name = separate(condition).get(2);
        return Mission.of(name);
    }

    private List<String> separate(String condition) {
        return Arrays.stream(condition.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(Level level, Mission mission) {
        if (!level.has(mission)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Condition)) {
            return false;
        }
        Condition condition = (Condition) o;
        return course == condition.course && level == condition.level && mission == condition.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}

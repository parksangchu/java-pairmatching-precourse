package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> crews;
    private final Level level;
    private final Mission mission;

    public Pair(List<String> crews, Level level, Mission mission) {
        this.crews = crews;
        this.level = level;
        this.mission = mission;
    }

    public List<String> getCrews() {
        return crews;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}

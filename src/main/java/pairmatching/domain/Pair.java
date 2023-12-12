package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<Crew> crews;
    private final Level level;
    private final Mission mission;

    public Pair(List<Crew> crews, Level level, Mission mission) {
        this.crews = crews;
        this.level = level;
        this.mission = mission;
    }
}

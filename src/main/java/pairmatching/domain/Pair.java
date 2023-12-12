package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> crews;
    private final Condition condition;

    public Pair(List<String> crews, Condition condition) {
        this.crews = crews;
        this.condition = condition;
    }

    public List<String> getCrews() {
        return crews;
    }

    public boolean has(Condition condition) {
        return this.condition
                .equals(condition);
    }

    public boolean has(Level level) {
        return this.condition
                .getLevel()
                .equals(level);
    }

    public boolean contains(List<String> crews) {
        return crews.stream()
                .filter(this.crews::contains)
                .count() >= 2;
    }
}

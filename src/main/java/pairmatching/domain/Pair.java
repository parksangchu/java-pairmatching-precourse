package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> crews;
    private Condition condition;

    public Pair(List<String> crews, Condition condition) {
        this.crews = crews;
        this.condition = condition;
    }

    public List<String> getCrews() {
        return crews;
    }

    public boolean has(Condition condition) {
        return this.condition.equals(condition);
    }
}

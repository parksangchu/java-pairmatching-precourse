package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_CONDITION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairGroup {
    private static final List<Pair> pairs = new ArrayList<>();


    public static void addPair(Pair pair) {
        pairs.add(pair);
    }

    public static List<Pair> pairs() {
        return Collections.unmodifiableList(pairs);
    }

    public static void findCondition(Condition condition) {
        if (!has(condition)) {
            throw new IllegalArgumentException(INVALID_CONDITION.getMessage());
        }
    }

    public static boolean has(Condition condition) {
        return pairs().stream()
                .anyMatch(pair -> pair.has(condition));
    }

    public static boolean contains(List<String> crews, Level level) {
        return pairs.stream()
                .filter(pair -> pair.has(level))
                .anyMatch(pair -> pair.contains(crews));
    }

    public static void delete(Condition condition) {
        pairs.removeIf(pair -> pair.has(condition));
    }

    public static void clear() {
        pairs.clear();
    }

}

package pairmatching.domain;

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
}

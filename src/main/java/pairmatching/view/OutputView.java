package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Condition;
import pairmatching.domain.Pair;

public class OutputView {
    private static final String PAIRS_FORMAT = "\n페어 매칭 결과입니다.\n%s\n";
    private static final String DELIMITER = " : ";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPairs(List<Pair> pairs, Condition condition) {
        List<String> pairNames = pairs.stream()
                .filter(pair -> pair.has(condition))
                .map(pair -> convertToString(pair.getCrews()))
                .collect(Collectors.toList());
        String names = String.join("\n", pairNames);
        System.out.printf(PAIRS_FORMAT, names);
    }

    private static String convertToString(List<String> names) {
        return String.join(DELIMITER, names);
    }
}

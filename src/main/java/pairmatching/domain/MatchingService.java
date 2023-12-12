package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    public static void matching(List<Crew> crews, Condition condition) {
        List<String> crewNames = getCrewNames(crews, condition);
        int count = 0;
        while (true) {
            validateCount(count);
            List<String> shuffledCrew = shuffleCrews(crewNames);
            List<List<String>> pairs = getPairs(shuffledCrew);
            if (pairs.stream()
                    .anyMatch(pair -> PairGroup.contains(pair, condition.getLevel()))) {
                count++;
                continue;
            }
            pairs.stream()
                    .map(pair -> new Pair(pair, condition))
                    .forEach(PairGroup::addPair);
            return;
        }
    }

    private static void validateCount(int count) {
        if (count == 3) {
            throw new IllegalArgumentException(Error.INVALID_MATCHING.getMessage());
        }
    }

    private static List<List<String>> getPairs(List<String> shuffledCrew) {
        List<List<String>> pairs = new ArrayList<>();
        for (int i = 0; i < shuffledCrew.size() - 1; i += 2) {
            List<String> crews = new ArrayList<>();
            crews.add(shuffledCrew.get(i));
            crews.add(shuffledCrew.get(i + 1));
            pairs.add(crews);
        }
        if (shuffledCrew.size() % 2 == 1) {
            pairs.get(pairs.size() - 1).add(shuffledCrew.get(shuffledCrew.size() - 1));
        }
        return pairs;
    }

    private static List<String> getCrewNames(List<Crew> crews, Condition condition) {
        return crews
                .stream()
                .filter(crew -> crew.has(condition.getCourse()))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    private static List<String> shuffleCrews(List<String> crews) {
        return Randoms.shuffle(crews);
    }
//
//    private static void matchingOdd(List<String> shuffledCrewNames, Condition condition) {
//        for (int i = 0; i < shuffledCrewNames.size() - 1; i += 2) {
//            List<String> pair = new ArrayList<>();
//            pair.add(shuffledCrewNames.get(i));
//            pair.add(shuffledCrewNames.get(i + 1));
//            if (i == shuffledCrewNames.size() - 3) {
//                pair.add(shuffledCrewNames.get(i + 2));
//            }
//            PairGroup.addPair(new Pair(pair, condition));
//        }
//    }
//
//    private static void matchingEven(List<String> shuffledCrewNames, Condition condition) {
//        List<Pair> pairs = new ArrayList<>();
//        for (int i = 0; i < shuffledCrewNames.size(); i += 2) {
//            List<String> crews = new ArrayList<>();
//            crews.add(shuffledCrewNames.get(i));
//            crews.add(shuffledCrewNames.get(i + 1));
//            if (PairGroup.contains(condition.getLevel(), crews)) {
//                return;
//            }
//            pairs.add(new Pair(crews, condition));
//        }
//        PairGroup.addPairs(pairs);
//    }
}

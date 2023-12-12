package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    public void matching(List<Crew> crews, Condition condition) {
        List<String> crewNames = getCrewNames(crews, condition);
        List<String> shuffledCrewNames = shuffleCrews(crewNames);
        if (shuffledCrewNames.size() % 2 == 1) {
            matchingOdd(shuffledCrewNames, condition);
            return;
        }
        matchingEven(shuffledCrewNames, condition);
    }

    private List<String> getCrewNames(List<Crew> crews, Condition condition) {
        return crews
                .stream()
                .filter(crew -> crew.has(condition.getCourse()))
                .map(crew -> crew.getName())
                .collect(Collectors.toList());
    }

    private List<String> shuffleCrews(List<String> crews) {
        return Randoms.shuffle(crews);
    }

    private void matchingOdd(List<String> shuffledCrewNames, Condition condition) {
        for (int i = 0; i < shuffledCrewNames.size() - 1; i += 2) {
            List<String> pair = new ArrayList<>();
            pair.add(shuffledCrewNames.get(i));
            pair.add(shuffledCrewNames.get(i + 1));
            if (i == shuffledCrewNames.size() - 3) {
                pair.add(shuffledCrewNames.get(i + 2));
            }
            PairGroup.addPair(new Pair(pair, condition.getLevel(), condition.getMission()));
        }
    }

    private void matchingEven(List<String> shuffledCrewNames, Condition condition) {
        for (int i = 0; i < shuffledCrewNames.size(); i += 2) {
            List<String> pair = new ArrayList<>();
            pair.add(shuffledCrewNames.get(i));
            pair.add(shuffledCrewNames.get(i + 1));
            PairGroup.addPair(new Pair(pair, condition.getLevel(), condition.getMission()));
        }
    }
}

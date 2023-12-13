package pairmatching.domain;

import org.junit.jupiter.api.Test;

class MatchingServiceTest {

    @Test
    void matching() {
        MatchingService matchingService = new MatchingService();
        for (int i = 0; i < 10; i++) {
            CrewGroup.addCrew(new Crew(Course.BACKEND, String.valueOf(i)));
            CrewGroup.addCrew(new Crew(Course.FRONTEND, String.valueOf(i)));
        }
        CrewGroup.addCrew(new Crew(Course.FRONTEND, "10"));

        Condition condition = new Condition("백엔드, 레벨1, 자동차경주");
        matchingService.matching(CrewGroup.crews(), condition);
        for (Pair pair : PairGroup.pairs()) {
            System.out.println(pair.getCrews().toString());
        }
    }
}
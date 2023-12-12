package pairmatching.domain;

import static pairmatching.domain.Mission.DISTRIBUTION;
import static pairmatching.domain.Mission.LOTTO;
import static pairmatching.domain.Mission.NUMBER_BASEBALL_GAME;
import static pairmatching.domain.Mission.PAYMENT;
import static pairmatching.domain.Mission.PERFORMANCE_IMPROVEMENT;
import static pairmatching.domain.Mission.RACING_GAME;
import static pairmatching.domain.Mission.SHOPPING_BASKET;
import static pairmatching.domain.Mission.SUBWAY_ROUTE_MAP;

import java.util.Arrays;
import java.util.List;


public enum Level {
    LEVEL1("레벨1", Arrays.asList(RACING_GAME, LOTTO, NUMBER_BASEBALL_GAME)),
    LEVEL2("레벨2", Arrays.asList(SHOPPING_BASKET, PAYMENT, SUBWAY_ROUTE_MAP)),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList(PERFORMANCE_IMPROVEMENT, DISTRIBUTION)),
    LEVEL5("레벨5", Arrays.asList());

    private String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }
    
}

package pairmatching.controller;

import pairmatching.domain.Condition;
import pairmatching.domain.Course;
import pairmatching.domain.CrewGroup;
import pairmatching.domain.CrewsMaker;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingService;
import pairmatching.domain.PairGroup;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    public void start() {
        CrewsMaker.makeCrews();
        while (true) {
            Function function = createFunction();
            MatchingService matchingService = new MatchingService();
            if (function.isQuit()) {
                break;
            }
            if (function.isPairMatching()) {
                Condition condition = createCondition();
                matchingService.matching(CrewGroup.crews(), condition);
                OutputView.printPairs(PairGroup.pairs(), condition);
            }
        }


    }

    private Function createFunction() {
        while (true) {
            try {
                String value = InputView.readFunction(Function.functions());
                return Function.of(value);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Condition createCondition() {
        while (true) {
            try {
                String condition = InputView.readCondition(Course.courses(), Level.levels());
                return new Condition(condition);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}

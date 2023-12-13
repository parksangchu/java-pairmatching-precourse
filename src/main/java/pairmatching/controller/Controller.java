package pairmatching.controller;

import pairmatching.domain.Condition;
import pairmatching.domain.Course;
import pairmatching.domain.CrewGroup;
import pairmatching.domain.CrewsMaker;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingService;
import pairmatching.domain.PairGroup;
import pairmatching.domain.ReMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    public void start() {
        CrewsMaker.makeCrews();
        repeatProcess();
    }

    private void repeatProcess() {
        while (true) {
            Function function = createFunction();
            if (function.isQuit()) {
                break;
            }
            if (function.isPairMatching()) {
                pairMatching();
            }
            if (function.isPairInquiry()) {
                pairInquiry();
            }
            if (function.isPairInitialization()) {
                PairGroup.clear();
            }
        }
    }

    private void pairMatching() {
        Condition condition = createCondition();
        if (PairGroup.has(condition)) {
            ReMatching reMatching = createRematching();
            if (!reMatching.isYes()) {
                return;
            }
            PairGroup.delete(condition);
        }
        try {
            MatchingService.matching(CrewGroup.crews(), condition);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            repeatProcess();
        }
        OutputView.printPairs(PairGroup.pairs(), condition);
    }

    private ReMatching createRematching() {
        while (true) {
            try {
                return ReMatching.of(InputView.readRematching());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private void pairInquiry() {
        try {
            Condition condition = createCondition();
            PairGroup.findCondition(condition);
            OutputView.printPairs(PairGroup.pairs(), condition);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
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

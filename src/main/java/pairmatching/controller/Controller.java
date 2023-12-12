package pairmatching.controller;

import pairmatching.domain.Condition;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    public void start() {
        Function function = createFunction();
        Condition condition = createCondition();
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

package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.view.InputView;

public class Controller {
    public void start() {
        String value = InputView.readFunction(Function.functions());
        String condition = InputView.readConditions(Course.courses(), Level.levels());
    }
}

package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.Function;

public class InputView {
    private static final String FUNCTIONS_NOTICE = "기능을 선택하세요.";
    private static final String FUNCTIONS_FORMAT = "%s. %s\n";

    public static String readFunction(List<Function> functions) {
        System.out.println(FUNCTIONS_NOTICE);
        functions.forEach(function -> System.out.printf(FUNCTIONS_FORMAT, function.getValue(), function.getName()));
        return Console.readLine();
    }
}

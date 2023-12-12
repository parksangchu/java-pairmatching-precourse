package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputView {
    private static final String FUNCTIONS_NOTICE = "기능을 선택하세요.";
    private static final String FUNCTIONS_FORMAT = "%s. %s\n";
    private static final String CONDITIONS_FORMAT =
            "\n#############################################\n과정: %s\n미션:"
                    + "\n%s############################################"
                    + "\n과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주\n";
    private static final String LEVELS_FORMAT = "  - %s: %s";
    private static final String DELIMITER = " | ";

    public static String readFunction(List<Function> functions) {
        System.out.println(FUNCTIONS_NOTICE);
        functions.forEach(function -> System.out.printf(FUNCTIONS_FORMAT, function.getValue(), function.getName()));
        return Console.readLine();
    }

    public static String readCondition(List<Course> courses, List<Level> levels) {
        List<String> courseNames = courses.stream()
                .map(Course::getName)
                .collect(Collectors.toList());
        System.out.printf(CONDITIONS_FORMAT, convertToString(courseNames), convertLevelsToString(levels));
        return Console.readLine();
    }

    public static String convertToString(List<String> names) {
        return String.join(DELIMITER, names);
    }

    public static String convertLevelsToString(List<Level> levels) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Level level : levels) {
            String line = String.format(LEVELS_FORMAT, level.getName(), convertToString(level.getMissions()
                    .stream()
                    .map(Mission::getName)
                    .collect(Collectors.toList())));
            stringBuilder.append(line + "\n");
        }
        return stringBuilder.toString();
    }
}

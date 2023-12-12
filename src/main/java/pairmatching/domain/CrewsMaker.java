package pairmatching.domain;

import static pairmatching.domain.Error.INVALID_FILE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrewsMaker {
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";

    public static void makeCrews() {
        makeBackEndCrews();
        makeFrontEndCrews();
    }

    private static void makeBackEndCrews() {
        File file = new File("src/main/resources/backend-crew.md");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines()
                    .forEach(name -> CrewGroup.addCrew(
                            new Crew(Course.of(BACKEND), name)));
        } catch (IOException e) {
            throw new RuntimeException(INVALID_FILE.getMessage());
        }
    }

    private static void makeFrontEndCrews() {
        File file = new File("src/main/resources/frontend-crew.md");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines()
                    .forEach(name -> CrewGroup.addCrew(new Crew(
                            Course.of(FRONTEND), name)));
        } catch (IOException e) {
            throw new RuntimeException(INVALID_FILE.getMessage());
        }
    }
}

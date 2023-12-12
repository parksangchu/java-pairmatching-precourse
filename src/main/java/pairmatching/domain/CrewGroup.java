package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewGroup {
    private static final List<Crew> crews = new ArrayList<>();

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }
}

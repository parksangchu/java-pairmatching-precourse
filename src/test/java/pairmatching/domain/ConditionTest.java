package pairmatching.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ConditionTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new Condition("백엔드, 레벨1, 성능개선"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
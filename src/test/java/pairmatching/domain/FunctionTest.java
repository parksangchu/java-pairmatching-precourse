package pairmatching.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class FunctionTest {

    @Test
    void of() {
        assertThatThrownBy(() -> Function.of("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
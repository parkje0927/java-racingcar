package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void requirement1() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void requirement2(int number) {
        // when
        boolean hasValue = numbers.contains(number);

        // then
        assertThat(hasValue).isTrue();
    }

    @ParameterizedTest
    @MethodSource("containsTestParameter")
    void requirement3(int number, boolean expected) {
        // when
        boolean result = numbers.contains(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> containsTestParameter() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, false)
        );
    }

}

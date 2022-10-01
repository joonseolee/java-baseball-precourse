package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
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
    @DisplayName("Set.size 사용할때 증복되지않은 요소 갯수를 리턴한다.")
    void whenGetSetSize_thenTotalSizeInNumbers() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set 요소를 확인할때 유효한 요소로 확인할경우 true 를 리턴한다.")
    void whenValidElementInTheSet_thenTrue(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:4:6:2", "8:4:3:7", "11:8:11:12"}, delimiter = ':')
    @DisplayName("Set 요소를 확인할때 유효하지않은 요소로 확인할경우 false 를 리턴한다.")
    void whenNotValidElementInTheSet_thenFalse(int element1,
                                               int element2,
                                               int element3,
                                               int targetIndex) {
        Set<Integer> targetNumbers = new HashSet<>();
        targetNumbers.add(element1);
        targetNumbers.add(element2);
        targetNumbers.add(element3);

        assertThat(targetNumbers.contains(targetIndex)).isFalse();
    }
}

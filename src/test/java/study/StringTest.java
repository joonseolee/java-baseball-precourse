package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    @DisplayName("String.split 사용할때 숫자와 콤마를 가진 문자열을 전달했을경우 숫자형태의 문자열로 이루어진 배열를 리턴한다.")
    void whenSplittingStringContainingNumbers_thenTwoNumbers() {
        String text = "1,2";

        String[] numbers = text.split(",");

        assertThat(numbers[0]).isEqualTo("1");
        assertThat(numbers[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("String.split 사용할때 숫자만 전달했을경우 하나의 숫자형태의 문자열로 이루어진 배열를 리턴한다.")
    void whenSplittingStringContainingNumber_thenArrayHasOneElement() {
        String text = "1";

        String[] numbers = text.split(",");

        assertThat(numbers)
                .contains("1")
                .containsExactly("1")
                .hasSize(1);
    }

    @Test
    @DisplayName("String.substring 사용할때 소괄호가 포함된 문자열을 전달했을경우 소괄호가 제거된 문자열을 리턴한다.")
    void whenSubstring_thenTextContainingTwoNumbers() {
        String text = "(1,2)";

        String result = text.substring(1, text.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt 사용할때 유효한 인덱스를 사용할경우 캐릭터형 타입을 리턴한다.")
    void whenCharAt_thenGettingChar() {
        String text = "abc";

        char firstWord = text.charAt(0);
        char secondWord = text.charAt(1);
        char thirdWord = text.charAt(2);

        assertThat(firstWord).isEqualTo('a');
        assertThat(secondWord).isEqualTo('b');
        assertThat(thirdWord).isEqualTo('c');
    }

    @Test
    @DisplayName("String.charAt 사용할때 유효하지않은 인덱스를 사용할경우 IndexOutOfBoundsException 에러를 던진다.")
    void whenCharAtWithNotCorrectIndexRange_thenThrowException() {
        String text = "abc";

        assertThatThrownBy(() -> text.charAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: -1");
        assertThatThrownBy(() -> text.charAt(6))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: 6");
    }
}

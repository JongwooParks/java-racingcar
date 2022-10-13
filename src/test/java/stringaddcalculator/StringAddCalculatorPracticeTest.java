package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorPracticeTest {

    /* @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculatorPractice.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }*/

    // 위의 테스트 처럼 2개를 테스트 할 때는 @ParameterizedTest를 고려해주세요.
    // given, when, then은 테스트코드를 연습하는 입장에서는 필수라 생각합니다.
    @ParameterizedTest(name = "input = {0}")
    @NullAndEmptySource // null과 empty값을 넣어줍니다.
    public void splitAndSum_null_또는_빈문자(String input) {

        // when
        int result = StringAddCalculatorPractice.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    // 다음과 같이 given, when, then을 한번 연습해보세요.
    @Test
    public void splitAndSum_숫자하나() throws Exception {
//        int result = StringAddCalculatorPractice.splitAndSum("1");
//        assertThat(result).isEqualTo(1);

        // given
        String input = "1";

        // when
        int result = StringAddCalculatorPractice.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculatorPractice.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculatorPractice.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculatorPractice.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    // 예외 테스트는 굳이 given, when, then은 필요없어보입니다.
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculatorPractice.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}

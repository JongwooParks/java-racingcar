package junitstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("구분자 있을때")
    public void split_구분자_있을때(){
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).containsExactly("1","2");
    }
    @Test
    @DisplayName("구분자 없을때")
    public void split_구분자_없을때(){
        //given
        String input = "1";
        //when
        String [] result = input.split(",");
        //then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("length 소괄호 제거")
    public void subString_length_소괄호제거(){
//        //given
//        String input = "(1,2)";
//        //when
//        String result = input.substring(1,input.length()-1);
//        //then
//       assertThat(result).isEqualTo("1,2");

        // 띄어쓰기는 가독성에 있어서 중요합니다. 위의 코드와 아래 코드를 비교해 주세요.

        //given
        String input = "(1,2)";

        //when
        String result = input.substring(1, input.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    // 아래 코드도 위 코드처럼 띄어쓰기 한번 해보세요.
    @Test
    @DisplayName("index 소괄호 제거")
    public void subString_index_소괄호제거(){
        //given
        String input = "(1,2)";
        //when
        String result = input.substring(input.indexOf("(")+1,input.indexOf(")"));
        //then
       assertThat(result).isEqualTo("1,2");
    }

    // given, when, then이 안되어있네요.
    @Test
    @DisplayName("charAt 특정 위치 문자 반환")
    public void charAt_특정위치_문자_반환() {
        String input = "abc";
        String result = String.valueOf(input.charAt(0));
        assertThat(result).isEqualTo("a");
    }

    @Test
    @DisplayName("subString 특정 위치 문자 반환")
    public void subString_특정위치_문자_반환() {
        String input = "abc";
        int index = 1;
        String result = input.substring(index, index + 1);
        assertThat(result).isEqualTo("b");
    }

    @Test
    @DisplayName("IndexOutOfBoundsException 발생")
    public void indexOutOfBoundsException_발생() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            String input = "abc";
            int errorIndex = 5;
            String result = String.valueOf(input.charAt(errorIndex));
        });
    }

    @Test
    @DisplayName("Exception Message 검사")
    public void exception_message_검사() {
        assertThatIOException().isThrownBy(() -> {
            throw new IOException("Exception message");
        }).withMessage("Exception message");
    }


}

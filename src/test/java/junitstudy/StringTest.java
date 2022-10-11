package junitstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("구분점 있을때")
    public void split(){

        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1", "2");

        //

    }
}

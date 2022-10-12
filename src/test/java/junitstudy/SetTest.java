package junitstudy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SetTest {
//    juniitstudy/SetTest.java 추가
//   - set_size_확인(): set은 중복 제거를 해주기 때문에 중복 된 값 한번만 저장
//   - set값_전체_존재_확인(int value): @ParameterizedTest와 @valuesource를 이용해 여러개의 값을 파라미터에 대입해서 실행
//   - set값_존재_여부_구별(int value, boolean result): @CsvSource를 이용해 두 파라미터에 여러쌍의 값을 대입, 자료형에 맞게 String값이 파싱된다

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set size 확인")
    public void set_size_확인(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set값 전체 존재 확인")
    public void set_값_전체_존재_확인(int value){
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter= ':' )
    public void set_값_존재_여부_확인(int value, boolean result){
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}

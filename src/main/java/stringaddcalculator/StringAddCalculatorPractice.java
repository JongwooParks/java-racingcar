package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorPractice {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    // static final은 상수로 메소드에 붙일 필요는 없습니다.
    static int splitAndSum(String input) {

        return calculator(castingStringToInt(input));
    }


    private static int calculator(int[] numbers) {
//        int result = 0;
//        for(Integer number : numbers) {
//            result += number;
//        }

        // 이게 간편하지 않을까요?
        return Arrays.stream(numbers).sum();
    }


    private static int[] separate(String input, String separator) {
//        return Arrays.stream(input.split(separator)).mapToInt(string -> Integer.parseInt(string))
//                .peek(number -> validatePositive(number)).toArray();

        // 람다를 그대로 사용해도 되지만 줄여쓰는 것도 좋아보입니다.
        return Arrays.stream(input.split(separator)).mapToInt(Integer::parseInt)
                .peek(StringAddCalculatorPractice::validatePositive).toArray();

    }


//    private static boolean isNullAndEmpty(String input) {
//        return input == null || input.isEmpty();
//    }

    // ||은 또는이니 메소드명도 isNullOrEmpty가 맞겠죠?
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }


    private static int[] castingStringToInt(String input) {

        if(isNullOrEmpty(input)) {
            return new int[] {0};
        }

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if(matcher.find()) {
            return separate(matcher.group(2), matcher.group(1));
        }

        return separate(input, ",|:");
    }


    private static void validatePositive(int number) {
        if(number < 0) {
            throw new RuntimeException("음수는 넣을 수 없습니다.");
        }
    }


}

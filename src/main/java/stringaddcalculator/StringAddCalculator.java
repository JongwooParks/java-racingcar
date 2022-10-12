package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static boolean isNullorEmpty(String input){
        return input ==null || input.isEmpty();
    }

    private static int calculate(int[] numbers){
        int result = 0;
        for(Integer number : numbers){
            result+= number;
        }
        return result;
    }

    private static int [] separate(String input, String separator){
        String [] splitResult = input.split(separator);
        int size = splitResult.length;
        int [] result = new int[size];
        for(int i =0; i<size;i++){
            int resultNumber = Integer.parseInt(splitResult[i]);
            validatePositive(resultNumber);
            result[i] = resultNumber;
        }
        return result;

//        return Arrays.stream(input.split(separator)).
//                mapToInt(string->Integer.parseInt(string))
//                .toArray();
    }

    private static Matcher getCustomSeparatorMatcher(String input){
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
        return pattern.matcher(input);
    }

    private static int[] castStringToInts(String input) {
        if (isNullorEmpty(input)) {
            return new int[] {0};
        }
        Matcher matcher = getCustomSeparatorMatcher(input);
        if (matcher.find()) {
            return separate(matcher.group(2), matcher.group(1));
        }
        return separate(input, ":|,");
    }

    private static void validatePositive(int number){
        if(number<0){
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }
    public static int splitAndSum(String input){
        return calculate(castStringToInts(input));
    }
}

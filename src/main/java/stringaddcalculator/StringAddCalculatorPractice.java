package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorPractice {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    static final int splitAndSum(String input){

        return calculator(castingStringToInt(input));
    }

    private static final int calculator(int [] numbers){
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static final int[] separate(String input, String separator){
        return Arrays.stream(input.split(separator)).mapToInt(string->Integer.parseInt(string))
                .peek(number->validatePositive(number))
                .toArray();

    }

    private static final boolean isNullAndEmpty(String input){
        return input==null || input.isEmpty();
    }


    private static final int[] castingStringToInt(String input){

        if(isNullAndEmpty(input)){
            return new int[] {0};
        }

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if (matcher.find()){
            return separate(matcher.group(2),matcher.group(1));
        }

        return separate(input,",|:");
    }

    private static void validatePositive(int number){
        if(number<0){
            throw new RuntimeException("음수는 넣을 수 없습니다.");
        }
    }





}

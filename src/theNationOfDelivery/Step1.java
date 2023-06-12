package theNationOfDelivery;

import java.util.Arrays;
import java.util.Optional;


public class Step1 {
    public String solution(String[] params) {
        Optional<String> answer = Arrays.stream(params)
                .map(String::toUpperCase)
                .filter(s -> s.length() >= 5 && s.length() <= 10)
                .findFirst();

        return answer.orElse("없음");
    }
    public static void main(String[] args) {
        Step1 solution = new Step1();
        String[] params = {"apple", "banana", "grape", "kiwi"};
        String answer = solution.solution(params);
        System.out.println(answer);
    }
}

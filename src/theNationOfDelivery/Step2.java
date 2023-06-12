package theNationOfDelivery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Step2 {
    public String solution(String[] leftArray, String[] rightArray) {
        String answer = "";

        Set<String> leftSet = new HashSet<>(Arrays.asList(leftArray));
        Set<String> rightSet = new HashSet<>(Arrays.asList(rightArray));

        Set<String> commonStrings = leftSet.stream()
                .filter(rightSet::contains)
                .collect(Collectors.toSet());

        if (commonStrings.isEmpty()) {
            return "";
        }

        answer = commonStrings.stream()
                .sorted()
                .collect(Collectors.joining(","));

        return answer;
    }

    public static void main(String[] args) {
        Step2 solution = new Step2();
        String[] leftArray = {"a", "b", "c"};
        String[] rightArray = {"b", "c", "d"};
        String result = solution.solution(leftArray, rightArray);
        System.out.println(result);
    }
}

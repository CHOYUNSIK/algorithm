package theNationOfDelivery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Step5 {
    public int[] solution(int[] card) {
        int answer[] = {
                2, 5
        };

        Map<Integer, Integer> cardCount = new HashMap<>();

        for (int num : card) {
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        for (int num : cardCount.keySet()) {
            if (cardCount.get(num) == 1) {
                answer[index++] = num;

                if (index == 2) {
                    break;
                }
            }
        }

        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Step5 solution = new Step5();

        int[][] inputs = {
                {1, 3, 2, 5, 3, 1},
                {1, 2, 3, 4, 4, 3, 2, 5}
        };

        for (int[] input : inputs) {
            int[] result = solution.solution(input);
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Result: " + Arrays.toString(result));
            System.out.println();
        }
    }

}

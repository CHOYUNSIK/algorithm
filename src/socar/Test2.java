package socar;

import java.util.Arrays;

/*
문제 설명
자연수 N개가 중복없이 들어있는 배열이 있습니다.
이때, 서로 다른 두 원소의 위치를 바꾸는 Swap 연산을 이용해 원소들의 위치를 바꿔 서로 인접한 원소의 차가 k 이하가 되도록 하려 합니다.
단, Swap 연산을 최대한 적게 사용해야 합니다
배열 numbers가 매개변수로 주어질 때, 서로 인접한 원소의 차가 k 이하가 되도록 하는데 필요한 Swap 횟수의 최솟값을 return 하도 록 solution 함수를 완성해주세요

제한사항
• numbers의 길이(N)는 1 이상 8 이하입니다.
• numbers의 원소는 1 이상 100 이하인 자연수입니다.
	• 숫자는 중복없이 들어있습니다.
• k는 1 이상 100 이하인 자연수입니다.
• 서로 인접한 원소의 자가 k 이하가 되도록 할 수 있는 방법이 없다면 -1을 return 하세요.

입출력 예
numbers                   k      result
[10, 40, 30, 20]          20     1
[3, 7, 2, 8, 6, 4, 5, 1]  3      2

입출력 예 설명

입출력 예 #1
30과 40의 위치를 바꾸면 [10, 30, 40, 20]이되며, 인접한 원소의 차가 모두 20 이하가 됩니다.

입출력 예 #2
3과 4의 위치를 바꾸고, 2와 5의 위치를 바꾸면 [4, 7, 5, 8, 6, 3, 2, 1]이 되며, 인접한 원소의 차가 모두 3 이하가 됩니다.
*/

public class Test2 {

    public static void main(String[] args) {
        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;
        int result1 = solution(numbers1, k1);
        System.out.println(result1); // Output: 1

        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;
        int result2 = solution(numbers2, k2);
        System.out.println(result2); // Output: 2
    }

    public static int solution(int[] numbers, int k) {
        int answer = -1;
        int n = numbers.length;
        boolean[] visited = new boolean[n];
        answer = dfs(numbers, visited, k, 0);
        return answer / 2;
    }

    public static int dfs(int[] numbers, boolean[] visited, int k, int count) {
        boolean check = true;
        for (boolean v : visited) {
            if (!v) {
                check = false;
                break;
            }
        }

        if (check)
            return count;

        int result = -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!visited[i]) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (!visited[j]) {
                        int diff = Math.abs(numbers[i] - numbers[j]);
                        if (diff <= k) {
                            visited[i] = true;
                            visited[j] = true;
                            int temp = dfs(numbers, visited, k, count + 1);
                            if (result == -1 || (temp != -1 && temp < result))
                                result = temp;
                            visited[i] = false;
                            visited[j] = false;
                        }
                    }
                }
            }
        }

        return result;
    }
}



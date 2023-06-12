package socar;

import java.util.Arrays;

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



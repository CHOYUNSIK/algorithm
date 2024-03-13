
package socar;

import java.sql.Array;
import java.util.*;

public class Test1_2 {
    public int[] solution(int n, int k, int[][] roads) {
        // 그래프 초기화
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], integer -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], integer -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        HashSet<Integer> result = new HashSet<>();

        dfs(graph, 0, k, result, 0);


        if (result.isEmpty()){
            return new int[]{-1};
        }else{
            return  result.stream().sorted().mapToInt(value -> value).toArray();
        }
    }

    private void dfs(Map<Integer, List<int[]>> graph, int current, int k, HashSet<Integer> result, int currentTime) {

        if (currentTime == k){
            result.add(current);
            return;
        }

        if (!graph.containsKey(current) || currentTime > k){
            return;
        }

        for (int[] x : graph.get(current)){
            dfs(graph, x[0], k , result, currentTime + x[1]);
        }

    }


    public static void main(String[] args) {
        Test1_2 solution = new Test1_2();

        // 테스트 케이스 1
        int n1 = 6;
        int k1 = 17;
        int[][] roads1 = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        int[] result1 = solution.solution(n1, k1, roads1);
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(result1));

        // 테스트 케이스 2
        int n2 = 4;
        int k2 = 10;
        int[][] roads2 = {{0, 1, 2}, {0, 2, 3}};
        int[] result2 = solution.solution(n2, k2, roads2);
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(result2));

        // 테스트 케이스 3
        int n3 = 4;
        int k3 = 11;
        int[][] roads3 = {{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}};
        int[] result3 = solution.solution(n3, k3, roads3);
        System.out.println("테스트 케이스 3 결과: " + Arrays.toString(result3));
    }
}

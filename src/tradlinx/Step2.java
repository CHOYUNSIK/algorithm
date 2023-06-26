package tradlinx;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Step2 {
    public static int solution(int N, int[][] relation, String[] dirname) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        List<Integer> pathLengths = new ArrayList<>();

        // 트리 생성
        for (int[] edge : relation) {
            int parent = edge[0];
            int child = edge[1];
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        // 가장 긴 경로 찾기
        int maxLength = 0;
        for (int i = 1; i <= N; i++) {
            maxLength = Math.max(maxLength, dfs(i, tree, dirname, pathLengths));
        }

        return maxLength - 1;
    }

    private static int dfs(int node, Map<Integer, List<Integer>> tree, String[] dirname, List<Integer> pathLengths) {
        if (node <= pathLengths.size() && pathLengths.get(node - 1) != 0) {
            return pathLengths.get(node - 1);
        }

        int maxLength = 0;
        if (tree.containsKey(node)) {
            for (int child : tree.get(node)) {
                maxLength = Math.max(maxLength, dfs(child, tree, dirname, pathLengths));
            }
        }

        int length = maxLength + dirname[node - 1].length() + 1;
        if (node > pathLengths.size()) {
            pathLengths.add(length);
        } else {
            pathLengths.set(node - 1, length);
        }

        return length;
    }



    public static void main(String[] args) {
        int N1 = 7;
        int[][] relation1 = {{1, 2}, {2, 5}, {2, 6}, {1, 3}, {1, 4}, {3, 7}};
        String[] dirname1 = {"root", "abcd", "cs", "hello", "etc", "hello", "solution"};
        int result1 = solution(N1, relation1, dirname1);
        System.out.println(result1); // 16

        int N2 = 7;
        int[][] relation2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 6}, {6, 7}};
        String[] dirname2 = {"root", "a", "b", "c", "d", "efghij", "K"};
        int result2 = solution(N2, relation2, dirname2);
        System.out.println(result2); // 13
    }



}

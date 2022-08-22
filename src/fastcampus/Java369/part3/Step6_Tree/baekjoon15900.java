
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon15900 {

    static int N, sum_leaf;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);

        }

        dfs15900(1, -1, 0);

        if (sum_leaf % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    private static void dfs15900(int x, int prev, int depth) {
        if (x != 1 && graph[x].size() == 1) sum_leaf += depth;
        for (int y : graph[x]) {
            if (y == prev) continue;
            dfs15900(y, x, depth + 1);
        }

    }


}

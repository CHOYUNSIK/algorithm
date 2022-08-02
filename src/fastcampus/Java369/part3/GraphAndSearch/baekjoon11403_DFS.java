
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11403_DFS {

    static int n;

    static int[][] graph;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs11403(i);
            for (int j = 1; j <= n; j++) {
                sb.append(visited[j] ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs11403(int x) {

        for (int y = 1; y <= n; y++) {

            if (visited[y]) continue;
            if (graph[x][y] == 0) continue;
            visited[y] = true;
            dfs11403(y);
        }
    }


}
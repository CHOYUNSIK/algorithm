
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11403_BFS {

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
            bfs11403(i);
            for (int j = 1; j <= n; j++) {
                sb.append(visited[j] ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs11403(int x) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = false;


        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int y = 1; y <= n; y++) {

                if (visited[y]) continue;
                if (graph[cur][y] == 0) continue;
                queue.add(y);
                visited[y] = true;
            }
        }


    }


}
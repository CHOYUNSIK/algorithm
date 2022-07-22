
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260_matrix {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[N + 1];

        dfs1260Matrix(V);

        sb.append("\n");

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        bfs1260Matrix(V);

        System.out.println(sb);
    }

    private static void bfs1260Matrix(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');

            for (int y = 1; y <= N; y++) {
                if (graph[x][y] == 0) continue;
                if (visited[y]) continue;
                queue.add(y);
                visited[y] = true;
            }

        }

    }

    private static void dfs1260Matrix(int v) {

        visited[v] = true;
        sb.append(v).append(' ');

        for (int y = 1; y <= N; y++) {
            if (graph[v][y] == 0) continue;

            if (visited[y]) continue;

            dfs1260Matrix(y);
        }

    }

}

package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1260_list {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs1260(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        bfs1260(V);

        System.out.println(sb);
    }

    private static void bfs1260(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');

            for (int y : graph[x]) {
                if (visited[y]) continue;
                queue.add(y);
                visited[y] = true;
            }
        }

    }

    private static void dfs1260(int v) {
        sb.append(v).append(' ');
        visited[v] = true;

        for (int y : graph[v]) {
            if (visited[y]) continue;
            dfs1260(y);
        }
    }
}
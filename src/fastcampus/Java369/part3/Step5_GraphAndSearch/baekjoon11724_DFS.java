
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11724_DFS {

    static int N, M, count;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            dfs11724(i);
            count++;
        }
        System.out.println(count);


    }

    private static void dfs11724(int i) {
        visited[i] = true;

        for (int x : graph[i]) {
            if (visited[x]) continue;
            dfs11724(x);
        }

    }

}

package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11725_DFS {

    static int n;

    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);

        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        dfs11725(1);

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);

    }

    private static void dfs11725(int start) {


        visited[start] = true;

        for(int y : graph[start]){
            if (visited[y]) continue;
            parent[y] = start;
            dfs11725(y);
        }

    }

}


package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2606_BFS {

    static int n, m, count = 0;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs2606(1);

        System.out.println(count);
    }

    private static void bfs2606(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int x : graph[cur]) {
                if (visited[x]) continue;
                queue.offer(x);
                visited[x] = true;
                count++;
            }
        }


    }


}